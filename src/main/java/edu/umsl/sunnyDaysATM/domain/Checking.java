package edu.umsl.sunnyDaysATM.domain;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author klm679
 */

public class Checking extends Account {
    
    Checking(){

        setTypeOfAccountNumber(1);
        setTypeOfAccountName("CHECKING");
    }

}
