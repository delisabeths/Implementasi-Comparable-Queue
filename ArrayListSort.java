/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sda0603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author herley
 */
public class ArrayListSort {
    public static void main(String[] args) {
        
        /**
         * Membuat Antrian menggunakan LinkedList di Java.
         */
        final Queue<Orang> queue = new LinkedList();
        
        /**
         * Membuat list orang.
         */
        final List<Orang> listOrang = new ArrayList();
        queue.add(new Orang(4,"A"));
        queue.add(new Orang(1,"B"));
        queue.add(new Orang(3,"C"));
        queue.add(new Orang(0,"D"));
        queue.add(new Orang(2,"E"));      
        
        /**
         * Queue dipindahkan ke List Orang.
         */
        Iterator<Orang> iterSatu = queue.iterator();
        while(iterSatu.hasNext()){
            /**
             * Mengambil orang dari Iterator.
             */
            final Orang ne = iterSatu.next();
            
            /**
             * Menambahkan Orang ke List.
             */
            listOrang.add(ne);
            /**
             * Menghapus Orang ini, dari Queue --> DEQUEUE.
             */
            iterSatu.remove();
        }
        
        /**
         * Proses pengurutan menggunakan Collections.sort(...), Catat bahwa pada Klas Orang HARUS mengimplementasikan interface Comparable<Orang>.
         */
        Collections.sort(listOrang);
        /**
         * Iterator untuk list orang.
         */
        Iterator<Orang> iterDua = listOrang.iterator();
        while (iterDua.hasNext()) {
            /**
             * Menambahkan Orang kedalam Queue.
             */
            queue.add(iterDua.next());
        }
        
        /**
         * Tampilkan hasil Queue.
         */
        System.out.println("queue = " + queue);
    }
}

/**
 * Klas Orang.
 * @author herley
 */
final class Orang implements Comparable<Orang>{
    private final int ktp;
    private final String nama;

    /**
     * Konstruktor.
     * @param ktp
     * @param nama 
     */
    public Orang(int ktp, String nama) {
        this.ktp = ktp;
        this.nama = nama;
    }
    
    /**
     * @return the ktp
     */
    public int getKtp() {
        return ktp;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * Implementasikan interface Comparable.
     * @param t
     * @return 
     */
    @Override
    public int compareTo(Orang t) {
        if(t.getKtp() == this.ktp){
            return 0;
        }else if(t.getKtp() > this.ktp){
            return 1;
        }else{
            return -1;
        }
    }

    /**
     * Tekan titik. Kemudian pilih to String.
     * @return 
     */
    @Override
    public String toString() {
        return "KTP: "+this.ktp+", Nama: "+this.nama;
    }
}