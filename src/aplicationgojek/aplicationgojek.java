package aplicationgojek;

import java.util.Scanner;

public class aplicationgojek {

    String username;

    int password;

    public static void main(String[] args) {

        String user="naufal";

        int pass = 12345;

        Scanner input = new Scanner(System.in);

        System.out.println("LOGIN");

        System.out.print("Masukkan user : ");

        String username=input.nextLine();

        System.out.print("Masukkan pass : ");

        int password=input.nextInt();
        
        if(username.equals(user)&&password==pass){

        int pilih;
        
        do{
            
        System.out.println("Silahkan pilih menu :");

            System.out.println("1.goRide");

            System.out.println("2.goFood");

            System.out.println("3.goSend");
            
            System.out.println("0.log Out");

            System.out.print("Masukkan pilihan : ");
            
            pilih = input.nextInt();

        switch(pilih){

            case 1:

            System.out.println("Anda memilih menu goRide silahkan pilih");

            System.out.println("1.Surabaya - Mojokerto");

            System.out.println("2.Surabaya - Sidoarjo");

            System.out.println("3.Surabaya - Gresik");

            System.out.print("Masukkan pilihan : ");

        int pilih1=input.nextInt();

            switch(pilih1){

            case 1:

             goRide a =new goRide("Surabaya","Mojokerto",2000,7);

             a.view_goRide();

               break;

             case 2:

             goRide b =new goRide("Surabaya","Sidoarjo",2000,5);

             b.view_goRide();
               break;
              case 3:
             goRide c =new goRide("Surabaya","Gresik",2000,3);
             c.view_goRide();
               break;
              }
            break;
            case 2:

            System.out.println("Anda memilih menu goFood silahkan pilih");
            System.out.println("1.Bakso");
            System.out.println("2.Nasi Goreng");
            System.out.println("3.Nasi Pecel");
            System.out.print("Masukkan pilihan : ");

        int pilih2=input.nextInt();
            switch(pilih2){
             case 1:
             goFood a =new goFood("Bakso",10000);
             a.view_goFood();
               break;

             case 2:

             goFood b =new goFood("Nasi Goreng",12000);
             b.view_goFood();
               break;
              case 3:
             goFood c =new goFood("Nasi Pecel",7000);
             c.view_goFood();
               break;
              }
            
            break;
            case 3:

            System.out.println("Anda memilih menu goSend silahkan pilih");
            System.out.println("1.Barang Kain");
            System.out.println("2.Barang Plastik");
            System.out.println("3.Barang Kaca");
            System.out.print("Masukkan pilihan : ");

        int pilih3=input.nextInt();
            switch(pilih3){
            case 1:
             goSend a =new goSend("Barang Kain",5.5,1.28);
             a.view_goSend();
               break;
             case 2:
             goSend b =new goSend("Barang Plastik",5.5,2);
             b.view_goSend();
               break;
              case 3:
             goSend c =new goSend("Barang Kaca",5.5,3.5);
             c.view_goSend();
               break;
              }
        }
        }while(pilih !=0);
       } else {
            System.out.println("login anda salah");
        }
    }   
}