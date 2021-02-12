package com.company;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<String[]> listData =  new ArrayList<String[]>();
    static Helper helper = new Helper();
    static Table table = new Table();

    public static void main(String[] args) {
        int option = 0;
        while (option != 3) {
            System.out.print ("Pemesanan Tiket Bioskop:                                             Detail Harga\n"
                    +  "1. Pemesanan Tiket                                                   Weekday: 50.000\n"
                    +  "2. Lihat Data Pesanan                                                Weekend: 60.000\n"
                    +  "3. Keluar\n"
                    +  "Pilih nomor: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    ticketReservation();
                    break;
                case 2:
                    displayData();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Pilihan hanya angka 1 - 3\n");
            }
        }
    }

    static void ticketReservation(){
        String filmData[] =  new String[5];
        System.out.print ("Masukkan Nama Pemesan: ");
        filmData[0] = scanner.next();
        System.out.print ("1. Terlalu Tampan\n" +
                "2. Milea\n" +
                "3. Bucin\n" +
                "4. Si Doel 2\n" +
                "Pilih Judul Film yang Diinginkan: ");
        int filmChoice = scanner.nextInt();
        filmData[1] = helper.chooseFilm(filmChoice);
//        do {
//            System.out.print ("Masukkan Grade Matakuliah: ");
//            filmData[2] = scanner.next().toUpperCase();
//        } while (!validateGrade(filmData[2]));
        System.out.print ("Pilih Hari: ");
        String dayChoice = scanner.next();
        filmData[2] = helper.chooseDay(dayChoice.toLowerCase());
        System.out.print ("1. 09.00\n" +
                "2. 12.00\n" +
                "3. 15.00\n" +
                "4. 18.00\n"+
                "Pilih Jam Tayang yang Diinginkan: ");
        int timeChoice = scanner.nextInt();
        filmData[3] = helper.chooseTime(timeChoice);
        System.out.print ("Masukkan jumlah tiket yang Diinginkan: ");
        filmData[4] = scanner.next();
        listData.add(filmData);
        System.out.print("Data Berhasil Terproses!\n");
    }

    static void displayData(){
        if (listData.size() < 1) {
            System.out.println("Data tidak ditemukan, silahkan masukkan pesanan terlebih dahulu");
            return;
        } else {
            table.setHeaders("Nama Pemesan", "Judul Film", "Hari", "Jam Tayang", "Jumlah Tiket",  "Total Bayar");
            for (int i=0; i< listData.size() ;i++){
                int ticket = Integer.parseInt(listData.get(i)[4]);
                table.addRow(
                listData.get(i)[0],
                listData.get(i)[1],
                listData.get(i)[2],
                listData.get(i)[3],
                listData.get(i)[4],
                String.valueOf(helper.paymentCalculation(ticket, listData.get(i)[2])));
            }
            table.print();
        }
    }

}
