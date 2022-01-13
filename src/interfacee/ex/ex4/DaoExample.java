// 연습문제 (매개변수의 다형화)
package interfacee.ex.ex4;

import interfacee.ex.ex5.DataAccessObject;

public class DaoExample {

    public static void dbWork(DataAccessObject dao) {
            dao.select();
            dao.insert();
            dao.update();
            dao.delete();
    }


    public static void main(String[] args) {
        dbWork(new OracleDao());
        dbWork(new MySqlDao());
    }
}
