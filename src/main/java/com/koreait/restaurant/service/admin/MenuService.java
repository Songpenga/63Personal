package com.koreait.restaurant.service.admin;

import com.koreait.restaurant.Exception.CustomValidationException;
import com.koreait.restaurant.entity.admin.MenuImage;
import com.koreait.restaurant.entity.admin.MenuMst;

import com.koreait.restaurant.repository.admin.MenuRepository;
import com.koreait.restaurant.web.dto.admin.MenuReqDto;
import com.koreait.restaurant.web.dto.admin.SearchNumberListReqDto;
import com.koreait.restaurant.web.dto.admin.SearchReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class MenuService {

    @Value("${file.path}")
    private String filePath;

    @Autowired
    private MenuRepository menuRepository;

    public Map<String, Object> getMenuAndImage(String menuCode) {
        Map<String, Object> result = new HashMap<>();
        result.put("menuMst", menuRepository.findMenuByMenuCode(menuCode));
        result.put("menuImage", menuRepository.findMenuImageByMenuCode(menuCode));

        return result;
    }

    public int getMenuTotalCount(SearchNumberListReqDto searchNumberListReqDto) {
        return menuRepository.getMenuTotalCount(searchNumberListReqDto);
    }


    public List<MenuMst> searchMenu(SearchReqDto searchReqDto) {
        searchReqDto.setIndex();
        return menuRepository.searchMenu(searchReqDto);
    }


    public void registerMenu(MenuReqDto menuReqDto) {
        duplicateMenuCode(menuReqDto.getMenuCode());
        menuRepository.saveMenu(menuReqDto);
    }

    private void duplicateMenuCode(String menuCode) {
        MenuMst menuMst = menuRepository.findMenuByMenuCode(menuCode);
        if(menuMst != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("menuCode", "이미 존재하는 메뉴코드입니다.");

            throw new CustomValidationException(errorMap);
        }
    }

    public void modifyMenu(MenuReqDto menuReqDto) {
        menuRepository.updateMenuByMenuCode(menuReqDto);
    }

    public void maintainModifyMenu(MenuReqDto menuReqDto) {
        menuRepository.maintainUpdateMenuByMenuCode(menuReqDto);
    }

    public void removeMenu(String menuCode) {
        menuRepository.deleteMenu(menuCode);
    }

    public void registerMenuImages(String menuCode, List<MultipartFile> files) {
        if(files.size() < 1) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("files", "이미지를 선택하세요.");

            throw new CustomValidationException(errorMap);
        }

        List<MenuImage> menuImages = new ArrayList<MenuImage>();

        files.forEach(file -> {
            String originFileName = file.getOriginalFilename();
            String extension = originFileName.substring(originFileName.lastIndexOf("."));
            String tempFileName = UUID.randomUUID().toString().replaceAll("-", "") + extension;

            Path uploadPath = Paths.get(filePath + "menu/" + tempFileName);

            File f = new File(filePath + "menu");
            if(!f.exists()) {
                f.mkdirs();
            }

            try {
                Files.write(uploadPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            MenuImage menuImage = MenuImage.builder()
                    .menuCode(menuCode)
                    .saveName(tempFileName)
                    .originName(originFileName)
                    .build();

            menuImages.add(menuImage);
        });

        menuRepository.registerMenuImages(menuImages);
    }

    public List<MenuImage> getMenus(String menuCode) {
        return menuRepository.findMenuImageAll(menuCode);
    }

    public void removeMenuImage(int imageId) {
        MenuImage menuImage = menuRepository.findMenuImageByImageId(imageId);

        if(menuImage == null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("error", "존재하지 않는 이미지 ID입니다.");

            throw new CustomValidationException(errorMap);
        }

        if(menuRepository.deleteMenuImage(imageId) > 0) {
            File file = new File(filePath + "menu/" + menuImage.getSaveName());
            if(file.exists()) {
                file.delete();
            }
        }
    }
}

