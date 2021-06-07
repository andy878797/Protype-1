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
public class Account {
        private String name;
        private double number;
        
        public Account(String name,double number){
            this.name = name;
            this.number = number;
        }
        
        public void plusnumber(double amount){
            this.number += amount;
        }
        
        public double Printnumber(){
                return this.number;
        }
        
        public void getName(String NameString){
            this.name += NameString;
        }
        
        public String PrintName(){
            return this.name;
        }
} 
