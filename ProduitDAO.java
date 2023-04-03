package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAO extends BaseDAO<Produit> {
    public ProduitDAO() throws SQLException {
        super();
    }

    // mapping objet --> relation
    @Override
    public void save(Produit object) throws SQLException {
        String req = "insert into client (nom) values (?);";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.execute();
    }

    @Override
    public void update(Produit object) throws SQLException {
        String req = "update produit set nom = ? where id_produit = ?;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setLong(3, object.getId_produit());
        this.preparedStatement.execute();
    }

    @Override
    public void delete(Produit object) throws SQLException {
        String req = "DELETE FROM client WHERE id_produit = ?;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setLong(1, object.getId_produit());
        this.preparedStatement.execute();
    }




    @Override
    public Client getOne(Long id) throws SQLException {
        return null;
    }


    // mapping relation --> objet
    @Override
    public List<Client> getAll() throws SQLException {
        List<Produit> mylist = new ArrayList<Produit>();
        String req = "select * from produit";

        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(req);

        while (this.resultSet.next()) {
            mylist.add(new Produit(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getString(3)));
        }

        return mylist;
    }
}
