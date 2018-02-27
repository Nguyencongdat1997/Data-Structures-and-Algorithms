/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DatGatto
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {                
        HashTable hashTable = new HashTable<String, Integer>(20);
        for (Integer i=0;i<4;i++){
            hashTable.put(""+i, i);
        }
        for (Integer i=0;i<4;i++){
            System.out.println("Number "+i +" : " +hashTable.get(""+i));
        } 
        System.out.println("Nubmer of list"+hashTable.numberOfList);
        for (Integer i=4;i<11;i++){
            hashTable.put(""+i, i);
        }
        System.out.println("Nubmer of list"+hashTable.numberOfList);
        System.out.println("Nubmer of key"+hashTable.numberOfKey);
        for (Integer i=0;i<11;i++){
            System.out.println("Number "+i +" : " +hashTable.get(""+i));
        }        
        for (Integer i=4;i<11;i++){
            hashTable.delete(""+i);
        }
        for (Integer i=0;i<11;i++){
            System.out.println("Number "+i +" : " +hashTable.get(""+i));
        }
        System.out.println("Nubmer of list: "+hashTable.numberOfList);
        System.out.println("Nubmer of key: "+hashTable.numberOfKey);
    }
    
}
