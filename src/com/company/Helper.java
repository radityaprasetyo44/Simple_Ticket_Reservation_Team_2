package com.company;

public class Helper {

    public String chooseFilm(int choice) {
        switch (choice) {
            case 1:
                return "Terlalu Tampan";
            case 2:
                return "Milea";
            case 3:
                return "Bucin";
            case 4:
                return "Si Doel 2";
            default:
                System.out.print("Pilihan tidak tersedia!");
                break;
        }
        return "";
    }

    public String chooseDay(String choice) {
        switch (choice) {
            case "senin" :
            case "selasa" :
            case "rabu" :
            case "kamis" :
            case "jumat" :
            case "sabtu" :
            case "minggu" :
                return choice;
            default:
                System.out.print("Hari tidak tersedia!");
                break;
        }
        return "";
    }

    public String chooseTime(int choice) {
        switch (choice) {
            case 1:
                return "09.00";
            case 2:
                return "12.00";
            case 3:
                return "15.00";
            case 4:
                return "18.00";
            default:
                System.out.print("Pilihan tidak tersedia!");
                break;
        }
        return "";
    }

    public int paymentCalculation(int ticket, String day) {
        int value = 0;
        switch (day) {
            case "senin" :
            case "selasa" :
            case "rabu" :
            case "kamis" :
            case "jumat" :
                value = 50000;
                break;
            case "sabtu" :
            case "minggu" :
                value = 60000;
                break;
        }
        return value * ticket;
    }
}
