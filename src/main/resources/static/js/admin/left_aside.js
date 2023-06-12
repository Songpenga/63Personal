window.onclick = () => {
    ComponentEvent.getInstance().addClickEventRoadReservationManagement();
    ComponentEvent.getInstance().addClickEventRoadMenuManagement();
    ComponentEvent.getInstance().addClickEventRoadMenuRegistration();
}

class ComponentEvent {
    static #instance = null;
    static getInstance() {
        if(this.#instance == null) {
            this.#instance = new ComponentEvent();
        }
        return this.#instance;
    }

    addClickEventRoadReservationManagement() {
        const reservationManagement = document.querySelector(".reservation-management");

        reservationManagement.onclick = () => {
            location.href = `http://localhost:8000/admin/reservation/management`;
        }

    }

    addClickEventRoadMenuManagement() {
        const menuManagement = document.querySelector(".menu-management");

        menuManagement.onclick = () => {
            location.href = `http://localhost:8000/admin/menu/management`;
        }
    }

    addClickEventRoadMenuRegistration() {
        const menuRegistration = document.querySelector(".menu-registration");

        menuRegistration.onclick = () => {
            location.href = `http://localhost:8000/admin/register`;
        }
    }
}