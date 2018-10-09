/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication6;

import static java.lang.Math.pow;

/**
 *
 * @author student
 */
public class User {
    public String name;
    private long P;
    private long A;
    public long Y;
    private long X;
    private long Z;
    private long Y2;
    
    public User (int P, int A, int X, String name)
    {
        this.P = P;
        this.A = A;
        this.X = X;
        this.name = name;
    }
    
    public String countY()
    {
        Y = (long)pow(A,X)%P;
        return "\n" + name + " Производит вычисления: " + "Y =" + A + "^" + X + "mod" + P
                + "\n Y = " + Y + "\n";
    }
    
    public String sendToUser(User sender, User getter, long Y)
    {
        sender.getFromUser(getter, sender, Y);
        
        return getFromUser(getter, sender, Y);
    }
    
    public String getFromUser(User getter, User sender, long Y)
    {
        getter.Y2 = Y;
        return sender.name + " Отправил " + Y + "\n" + getter.name + " Получил " + Y;
    }
    
    public String closedKey()
    {
        Z = (long)pow(Y2, X) % P;
        return "\n" + name + " вычислил закрытый ключ: " + Z;
    }
    
}
