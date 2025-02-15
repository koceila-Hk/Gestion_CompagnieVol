package fr.asl.travel.doranco.dao;

public class Requete {
	public static final String AJOUT_AEROPORT = "INSERT INTO Aeroport(nom) VALUES(?)";
    public static final String AEROPORT_PAR_ID = "SELECT id, nom FROM Aeroport WHERE id=?";
    public static final String TOUS_LES_AEROPORTS = "SELECT id, nom FROM Aeroport";
    public static final String UPDATE_AEROPORT = "UPDATE Aeroport SET nom =? WHERE id = ?";

    public static final String AJOUT_COMPAGNIE = "INSERT INTO Compagnie(nom) VALUES(?)";
    public static final String COMPAGNIE_PAR_ID = "SELECT id, nom FROM Compagnie WHERE id=?";
    public static final String TOUTES_LES_COMPAGNIES = "SELECT id, nom FROM Compagnie";
    public static final String SUPPRESSION_COMPAGNIE = "DELETE FROM Compagnie where id=?";

    public static final String AJOUT_VOL = "INSERT INTO Vol(dateHeureDepart, dateHeureArrivee, prixEnEuro, compagnie_id, aeroportDepart_id, aeroportArrivee_id ) VALUES (?,?,?,?,?,?)";
    public static final String VOL_PAR_ID = "SELECT heureDepart, heureArrivee, prixEnEuros, compagnie_id, aeroport_depart_id, aeroport_arrivee_id FROM Vol WHERE id=?";
    public static final String TOUS_LES_VOLS = "SELECT id, dateHeureArrivee, dateHeureDepart, prixEnEuro, aeroportArrivee_id, aeroportDepart_id, compagnie_id FROM Vol ORDER BY prixEnEuro";

}