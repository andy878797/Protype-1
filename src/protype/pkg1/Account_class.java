/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protype.pkg1;

/**
 *
 * @author s1083729
 */
public class Account_class {
    class Account{
        private String name;
        private double number;
        
        public Account(String name,double number){
            this.name = name;
            this.number = number;
        }
        
        public void plusnumber(double amount){
            this.number += amount;
        }
        
        public String toString(){
            return String.format(this.name,this.number);
        }
    } 
}
