/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mgw.main;

import mgw.gameplay.Player;

/**
 *
 * @author mejap
 */
public record HistoryLog(Account challenger, Account challenged, Account winner, int turns){}
