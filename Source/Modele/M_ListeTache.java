package Modele;

import Modele.M_Tache;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class M_ListeTache
{
    private ArrayList<M_Tache> tachesEnCours;
    private ArrayList<M_Tache> tachesEchues;

    private Comparator<M_Tache> comparator;

    public M_ListeTache()
    {
        tachesEnCours = new ArrayList<M_Tache>();
        tachesEchues = new ArrayList<M_Tache>();

        comparator = new Comparator<M_Tache>()
        {
            @Override
            public int compare(M_Tache o1, M_Tache o2) {
                return o1.getEcheance().compareTo(o2.getEcheance());
            }
        };
    }

    public void ajouterTache(M_Tache tache)
    {
        tachesEnCours.add(tache);

    }

    private void verifierEcheance()
    {
        Calendar dateActuelle = Calendar.getInstance();

        for(int i = 0; i < tachesEnCours.size(); i++)
        {
            if(tachesEnCours.get(i).isEchue(dateActuelle))
            {
                M_Tache tache = tachesEnCours.get(i);
                tachesEnCours.remove(i);
                i--;
                tachesEchues.add(tache);
            }
        }
    }

    private void ordonnerListe()
    {
        // tri des taches en cours
        Collections.sort(tachesEnCours, comparator);

        // tri des taches echues
        Collections.sort(tachesEchues, comparator.reversed());
    }
}
