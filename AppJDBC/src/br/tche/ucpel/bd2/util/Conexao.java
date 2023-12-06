package br.tche.ucpel.bd2.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por fazer uma conexão ao SGBD e entrega-la pelo método
 * static. A responsabilidade de fechar a conexão não é desta classe. Também não
 * é dela o controle de quantas conexões serão feiras. Importante é configurar o
 * drive jdbc para o SGBD (Postgresql, MySql, Oracle, Java DB, etc), a base de
 * dados em si, o usuário e a senha. Esta classe pode facilmente ser adaptada
 * para ler estas informações de uma arquivo txt ou xml. É importante que o
 * drive jdbc esteja especificado nas bibliotecas deste projeto.
 *
 * @author mertins
 */
public class Conexao {

    /**
     * Método que faz a conexão e o retorna
     *
     * @return Connection com o SGBD
     * @throws ClassNotFoundException exception lançada se não for encontrado o
     * drive (verificar as bibliotecas necessárias)
     * @throws SQLException exception lançada se alguma chamada ao SGBD falhar
     * (sql errado, acesso negado, etc)
     */
    public static Connection get() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
//        return DriverManager.getConnection("jdbc:postgresql://localhost/BaseUCPel", "aluno", "qpwo");
//        Class.forName("org.apache.derby.jdbc.ClientDriver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JavaTreinamento",
                "mmsis", "teste12");
    }
}
