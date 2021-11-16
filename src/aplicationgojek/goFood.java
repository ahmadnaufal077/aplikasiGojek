package aplicationgojek;

public class goFood {

    String nama;

    int harga,total;

    int ongkir = 2000;

    public goFood(String nama1,int harga1){

      this.nama =nama1;

      this.harga=harga1;

      total=harga+ongkir;

    }

    void view_goFood(){

        System.out.println("Anda memilih "+nama);

        System.out.println("Total order  : "+total);

    }

}