package com.exemple.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreditDAO extends BaseDAO<Credit> {
    public CreditDAO() throws SQLException {
        super();
    }

    // mapping objet --> relation
    @Override
    public void save(Credit object) throws SQLException {
        String req = "insert into credit (nom, montant) values (?, ?);";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setString(2, object.getMontant());
        this.preparedStatement.execute();
    }

    @Override
    public void update(Credit object) throws SQLException {
        String req = "update client set nom = ?, montant = ? where id_credit = ?;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setString(1, object.getNom());
        this.preparedStatement.setString(2, object.getMontant());
        this.preparedStatement.setLong(3, object.getId_credit());
        this.preparedStatement.execute();
    }

    @Override
    public void delete(Credit object) throws SQLException {
        String req = "DELETE FROM credit WHERE id_credit = ?;";

        this.preparedStatement = this.connection.prepareStatement(req);
        this.preparedStatement.setLong(1, object.getId_credit());
        this.preparedStatement.execute();
    }




    @Override
    public Credit getOne(Long id) throws SQLException {
        return null;
    }


    // mapping relation --> objet
    @Override
    public List<Credit> getAll() throws SQLException {
        List<Credit> mylist = new ArrayList<Credit>();
        String req = "select * from credit";

        this.statement = this.connection.createStatement();
        this.resultSet = this.statement.executeQuery(req);

        while (this.resultSet.next()) {
            mylist.add(new Credit(this.resultSet.getLong(1), this.resultSet.getString(2), this.resultSet.getString(3)));
        }

        return mylist;
    }
}
