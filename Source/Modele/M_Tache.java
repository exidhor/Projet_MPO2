package Modele;

import java.util.Calendar;

public class M_Tache
{
    private String message;
    private Calendar echeance;

    public M_Tache(String message, Calendar echeance)
    {
        this.message = message;
        this.echeance = echeance;
    }

    public String getMessage()
    {
        return message;
    }

    public Calendar getEcheance()
    {
        return echeance;
    }

    public boolean isEchue(Calendar dateActuelle)
    {
        echeance.add(Calendar.DATE, 1);
        boolean res = echeance.before(dateActuelle);
        echeance.add(Calendar.DATE, -1);

        return res;
    }
}
