package com.example.baitaplonoop.sql;

import java.sql.*;
<<<<<<< HEAD
import java.text.ParseException;
import java.text.SimpleDateFormat;
=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {
    public Connection con;
    public DBConnect() {
        try {
<<<<<<< HEAD
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Exam_Management2";
            String username = "postgres";
            String password = "Maianh1010?";
=======
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://DESKTOP-AP629KT\\SQLEXPRESS:1433;databaseName=Exam_Management2;"
                    + "encrypt=true;trustServerCertificate=true;sslProtocol=TLSv1.2";
            String username = "sa";
            String password = "hoangphuc0703";
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet getData(String stringSQL) {
        ResultSet rs = null;
        try {
            Statement state = con.createStatement();
            rs = state.executeQuery(stringSQL);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
<<<<<<< HEAD

=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
    public int InsertQuestion(String[] stringSQL) {
        int rowInserted;
        String sql = "INSERT INTO Question(categoryID, questionID, questionText, questionMark, questionMedia) values(?,?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
<<<<<<< HEAD
            statement.setDouble(4, Double.parseDouble(stringSQL[3]));
=======
            statement.setString(4, stringSQL[3]);
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
            statement.setString(5, stringSQL[4]);
            rowInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowInserted;
    }
<<<<<<< HEAD


//    public int InsertQuestion(String[] stringSQL) {
//        int rowInserted;
//        String sql = "INSERT INTO Question(categoryID, questionID, questionText, questionMark, questionMedia) values(?,?,?,?,?)";
//        PreparedStatement statement;
//        try {
//            statement = con.prepareStatement(sql);
//            statement.setString(1, stringSQL[0]);
//            statement.setString(2, stringSQL[1]);
//            statement.setString(3, stringSQL[2]);
//            statement.setString(4, stringSQL[3]);
//            statement.setString(5, stringSQL[4]);
//            rowInserted = statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowInserted;
//    }

=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
//    public int InsertQuestion(String[] stringSQL) {
//        int rowInserted = 0;
//        String sql = "INSERT INTO Question(categoryID, questionID, questionText) values(?,?,?)";
//        PreparedStatement statement;
//        try {
//            statement = con.prepareStatement(sql);
//            statement.setString(1, stringSQL[0]);
//            statement.setString(2, stringSQL[1]);
//            statement.setString(3, stringSQL[2]);
//            rowInserted = statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowInserted;
//    }
    public int InsertChoice(String[] stringSQL) {
        int rowInserted ;
        String sql = "INSERT INTO Choice(choiceText, choiceGrade, choiceID, questionID, isSelected, choiceMedia) values(?,?,?,?,?,?)";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setFloat(2, Float.parseFloat(stringSQL[1]));
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
<<<<<<< HEAD
            statement.setBoolean(5, Boolean.parseBoolean(stringSQL[4]));
=======
            statement.setString(5, stringSQL[4]);
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
            statement.setString(6, stringSQL[5]);
            rowInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowInserted;
    }
    public int InsertQuestionInQuiz(String[] stringSQL) throws SQLException {
        int rowInserted ;
        String sql = "insert into QuestionInQuiz(questionID,quizName,yourMark) values(?,?,?)";
        PreparedStatement statement;
        statement = con.prepareStatement(sql);
        statement.setString(1, stringSQL[0]);
        statement.setString(2, stringSQL[1]);
<<<<<<< HEAD
        if (stringSQL[2] != null) {
            double yourMark = Double.parseDouble(stringSQL[2].trim());
            statement.setDouble(3, yourMark);
        } else {
            // Xử lý trường hợp giá trị là null, có thể đặt giá trị mặc định hoặc thực hiện các hành động phù hợp
            statement.setNull(3, java.sql.Types.DOUBLE);
        }
=======
        statement.setString(3, stringSQL[2]);
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
        rowInserted = statement.executeUpdate();
        return rowInserted;
    }
    public String FindCategoryID(String categoryName) throws SQLException {
        String categoryID = null;
        String sql = "SELECT categoryID FROM Category WHERE categoryName = N'" + categoryName + "'";
        ResultSet result = getData(sql);
        if (result.next()) {
            categoryID = result.getString("categoryID");
        }
        return categoryID;
    }
    public void InsertCategory(String[] stringSQL) {
        int rowInserted;
        String sql = "INSERT INTO Category(parentID, categoryName, categoryID, categoryinfo) values (?, ?, ?, ?)";
        PreparedStatement statement;
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            rowInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
<<<<<<< HEAD

    private Timestamp convertStringToTimestamp(String dateString) throws SQLException {
        try {
            // Định dạng của chuỗi thời gian ban đầu
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

            // Chuyển đổi thành đối tượng Timestamp
            return new Timestamp(inputFormat.parse(dateString).getTime());
        } catch (ParseException e) {
            throw new SQLException("Invalid timestamp format", e);
        }
    }

=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
    public int AddNewQuiz(String[] stringSQL) {
        int rowInserted = 0;
        String sql = "INSERT INTO Quiz(quizName, Descript, openTime, closeTime, timeLimit) values (?, ?, ?, ?, ?)";
        PreparedStatement statement;
<<<<<<< HEAD

=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
        try {
            statement = con.prepareStatement(sql);
            statement.setString(1, stringSQL[0]);
            statement.setString(2, stringSQL[1]);
<<<<<<< HEAD

            // Chuyển đổi String sang Timestamp (ví dụ, bạn có thể sử dụng java.sql.Timestamp)
            Timestamp openTime = convertStringToTimestamp(stringSQL[2]);
            statement.setTimestamp(3, openTime);

            Timestamp closeTime = convertStringToTimestamp(stringSQL[3]);
            statement.setTimestamp(4, closeTime);

            // Sửa đổi này để đặt giá trị nguyên cho timeLimit
            int timeLimit = Integer.parseInt(stringSQL[4]);
            statement.setInt(5, timeLimit);



=======
            statement.setString(3, stringSQL[2]);
            statement.setString(4, stringSQL[3]);
            statement.setString(5, stringSQL[4]);
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
            rowInserted = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowInserted;
    }
<<<<<<< HEAD


    //    public int AddNewQuiz(String[] stringSQL) {
//        int rowInserted = 0;
//        String sql = "INSERT INTO Quiz(quizName, Descript, openTime, closeTime, timeLimit) values (?, ?, ?, ?, ?)";
//        PreparedStatement statement;
//        try {
//            statement = con.prepareStatement(sql);
//            statement.setString(1, stringSQL[0]);
//            statement.setString(2, stringSQL[1]);
//            statement.setString(3, stringSQL[2]);
//            statement.setString(4, stringSQL[3]);
//            statement.setString(5, stringSQL[4]);
//            rowInserted = statement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return rowInserted;
//    }
=======
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
    public String[] FindQuestionInfo(String questionID) {
        String[] questionInfo = null;
        String sql = "SELECT questionText,questionMedia FROM Question WHERE questionID = ?";
        try (
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, questionID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
<<<<<<< HEAD
                //String questionText = rs.getNString("questionText");
                String questionText = rs.getString("questionText");
=======
                String questionText = rs.getNString("questionText");
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
                String questionMedia = rs.getString("questionMedia");
                questionInfo = new String[]{questionText, questionMedia};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionInfo;
    }
    public String[] FindChoiceInfo(String choiceID) {
        String[] choiceInfo = null;
        String sql = "SELECT choiceText, choiceGrade, choiceMedia FROM choice WHERE choiceID = ?";
        try (
                PreparedStatement statement = con.prepareStatement(sql);
        ) {
            statement.setString(1, choiceID);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
<<<<<<< HEAD
                //String choiceText = rs.getNString("choiceText");
                String choiceText = rs.getString("choiceText");
=======
                String choiceText = rs.getNString("choiceText");
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
                Float choiceGrade = rs.getFloat("choiceGrade");
                String choiceMedia = rs.getString("choiceMedia");
                choiceInfo = new String[]{choiceText, String.valueOf(choiceGrade), choiceMedia};
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return choiceInfo;
    }
<<<<<<< HEAD

    public void UpdateQuestion(String[] questionInfo) throws SQLException {
        int rowsAffected = 0;

        // Thực hiện UPDATE
        String updateSql = "UPDATE question SET questionText = ?, categoryID = ?, questionMedia = ?, questionMark = ? WHERE questionID = ?";
        try (PreparedStatement updateStatement = con.prepareStatement(updateSql)) {
            updateStatement.setString(1, questionInfo[2]);  // questionText
            updateStatement.setString(2, questionInfo[0]);  // categoryID
            updateStatement.setString(3, questionInfo[4]);  // questionMedia
            updateStatement.setFloat(4, Float.parseFloat(questionInfo[3]));  // questionMark
            updateStatement.setString(5, questionInfo[1]);  // questionID
            rowsAffected = updateStatement.executeUpdate();
        }

        // Nếu không có dòng nào được cập nhật, thực hiện INSERT
        if (rowsAffected == 0) {
            String insertSql = "INSERT INTO question (questionID, questionText, categoryID, questionMark, questionMedia) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = con.prepareStatement(insertSql)) {
                insertStatement.setString(1, questionInfo[1]);  // questionID
                insertStatement.setString(2, questionInfo[2]);  // questionText
                insertStatement.setString(3, questionInfo[0]);  // categoryID
                insertStatement.setFloat(4, Float.parseFloat(questionInfo[3]));  // questionMark
                insertStatement.setString(5, questionInfo[4]);  // questionMedia
                insertStatement.executeUpdate();
            }
        }
    }

//    public void UpdateQuestion(String[] questionInfo) throws SQLException {
//        int rowInserted = 0;
//        String sql = "MERGE Question AS target USING (VALUES (?,?,?,?,?)) " +
//                "AS source (categoryID, questionID, questionText, questionMark, questionMedia)  " +
//                "ON target.questionID = source.questionID  " +
//                "WHEN MATCHED THEN  UPDATE SET questionText = source.questionText,  " +
//                "categoryID = source.categoryID, questionMedia = source.questionMedia, questionMark = source.questionMark " +
//                "WHEN NOT MATCHED THEN  INSERT (questionID, questionText, categoryID, questionMark, questionMedia)  " +
//                "VALUES (source.questionID, source.questionText, source.categoryID,source.questionMark, source.questionMedia);";
//        PreparedStatement statement;
//        statement = con.prepareStatement(sql);
//        statement.setString(1, questionInfo[0]);
//        statement.setString(2, questionInfo[1]);
//        statement.setString(3, questionInfo[2]);
//        statement.setFloat(4, Float.parseFloat(questionInfo[3]));
//        statement.setString(5, questionInfo[4]);
//        //statement.executeUpdate();
//        rowInserted = statement.executeUpdate();
//
//    }

    public void UpdateChoice(String[] choiceInfo) throws SQLException {
        String sql = "INSERT INTO Choice (choiceText, choiceGrade, choiceID, questionID, choiceMedia) " +
                "VALUES (?, ?, ?, ?, ?) " +
                "ON CONFLICT (choiceID) DO UPDATE SET " +
                "choiceText = EXCLUDED.choiceText, " +
                "choiceGrade = EXCLUDED.choiceGrade, " +
                "questionID = EXCLUDED.questionID, " +
                "choiceMedia = EXCLUDED.choiceMedia";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, choiceInfo[0]);  // choiceText
            statement.setFloat(2, Float.parseFloat(choiceInfo[1]));  // choiceGrade
            statement.setString(3, choiceInfo[2]);  // choiceID
            statement.setString(4, choiceInfo[3]);  // questionID
            statement.setString(5, choiceInfo[4]);  // choiceMedia
            statement.executeUpdate();
        }
    }


    //    public void UpdateChoice(String[] choiceInfo) throws SQLException {
//        int rowInserted = 0;
//        String sql = "MERGE Choice AS target USING (VALUES (?,?,?,?,?)) AS source (choiceText, choiceGrade, choiceID, questionID, choiceMedia)  ON target.choiceID = source.choiceID  WHEN MATCHED THEN  UPDATE SET choiceText = source.choiceText,  choiceGrade = source.choiceGrade, choiceID = source.choiceID,questionID = source.questionID, choiceMedia = source.choiceMedia  WHEN NOT MATCHED THEN  INSERT (choiceText, choiceGrade, choiceID, questionID, choiceMedia)  VALUES (source.choiceText, source.choiceGrade, source.choiceID, source.questionID, source.choiceMedia);";
//        PreparedStatement statement;
//        statement = con.prepareStatement(sql);
//        statement.setString(1, choiceInfo[0]);
//        statement.setFloat(2, Float.parseFloat(choiceInfo[1]));
//        statement.setString(3, choiceInfo[2]);
//        statement.setString(4, choiceInfo[3]);
//        statement.setString(5,  choiceInfo[4]);
//        rowInserted = statement.executeUpdate();
//
//    }

    public void updateQuiz(boolean a, String quizName) throws SQLException {
        boolean result = false;
        String sql = "UPDATE Quiz SET shuffle = ? WHERE quizName = ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setBoolean(1, a);
            statement.setString(2, quizName);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            // Xử lý exception nếu cần thiết
            e.printStackTrace();
        }
    }

//    public void updateQuiz(boolean a, String quizName) throws  SQLException{
//        boolean result =false;
//        String sql="update Quiz set shuffle = ? where quizName = N'"+quizName+"'";
//        PreparedStatement statement;
//        statement=con.prepareStatement(sql);
//        statement.setString(1,Boolean.toString(a));
//        result = statement.execute();
//    }
=======
    public void UpdateQuestion(String[] questionInfo) throws SQLException {
        int rowInserted = 0;
        String sql = "MERGE Question AS target USING (VALUES (?,?,?,?,?)) " +
                "AS source (categoryID, questionID, questionText, questionMark, questionMedia)  " +
                "ON target.questionID = source.questionID  " +
                "WHEN MATCHED THEN  UPDATE SET questionText = source.questionText,  " +
                "categoryID = source.categoryID, questionMedia = source.questionMedia, questionMark = source.questionMark " +
                "WHEN NOT MATCHED THEN  INSERT (questionID, questionText, categoryID, questionMark, questionMedia)  " +
                "VALUES (source.questionID, source.questionText, source.categoryID,source.questionMark, source.questionMedia);";
        PreparedStatement statement;
        statement = con.prepareStatement(sql);
        statement.setString(1, questionInfo[0]);
        statement.setString(2, questionInfo[1]);
        statement.setString(3, questionInfo[2]);
        statement.setFloat(4, Float.parseFloat(questionInfo[3]));
        statement.setString(5, questionInfo[4]);
        rowInserted = statement.executeUpdate();

    }
    public void UpdateChoice(String[] choiceInfo) throws SQLException {
        int rowInserted = 0;
        String sql = "MERGE Choice AS target USING (VALUES (?,?,?,?,?)) AS source (choiceText, choiceGrade, choiceID, questionID, choiceMedia)  ON target.choiceID = source.choiceID  WHEN MATCHED THEN  UPDATE SET choiceText = source.choiceText,  choiceGrade = source.choiceGrade, choiceID = source.choiceID,questionID = source.questionID, choiceMedia = source.choiceMedia  WHEN NOT MATCHED THEN  INSERT (choiceText, choiceGrade, choiceID, questionID, choiceMedia)  VALUES (source.choiceText, source.choiceGrade, source.choiceID, source.questionID, source.choiceMedia);";
        PreparedStatement statement;
        statement = con.prepareStatement(sql);
        statement.setString(1, choiceInfo[0]);
        statement.setFloat(2, Float.parseFloat(choiceInfo[1]));
        statement.setString(3, choiceInfo[2]);
        statement.setString(4, choiceInfo[3]);
        statement.setString(5,  choiceInfo[4]);
        rowInserted = statement.executeUpdate();

    }
    public void updateQuiz(boolean a, String quizName) throws  SQLException{
        boolean result =false;
        String sql="update Quiz set shuffle = ? where quizName = N'"+quizName+"'";
        PreparedStatement statement;
        statement=con.prepareStatement(sql);
        statement.setString(1,Boolean.toString(a));
        result = statement.execute();
    }
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
    public boolean checkQuestionID(String questionID) throws SQLException {
        boolean result = false;
        String sql = "SELECT * FROM Question WHERE questionID = ?"; // Câu lệnh SQL truy vấn dữ liệu theo questionID
        PreparedStatement statement;
        statement = con.prepareStatement(sql);
        statement.setString(1, questionID); // Thiết lập giá trị cho tham số
        ResultSet rs = statement.executeQuery(); // Thực hiện câu lệnh và lấy kết quả trả về
        if (rs.next()) { // Kiểm tra xem kết quả có dòng nào hay không
            result = true; // Nếu có, nghĩa là questionID tồn tại
        }
        return result; // Trả về giá trị boolean
    }
    public void updateQuizMark(double mark, String quizChosen){
        int rowUpdated = 0;
        String sql = "Update Quiz set mark = ? where quizName = N'" + quizChosen + "'";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
<<<<<<< HEAD
            statement.setDouble(1, mark);
=======
            statement.setString(1, String.valueOf(mark));
>>>>>>> ab47b89253bbb1b618244df2e095ad0133aa0e57
            rowUpdated = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertIntoHistory(String quizName, double mark, LocalDateTime dateAttempt){
        boolean rowInserted = false;
        String querry = "Insert into HistoryAttempt (quizName, mark, dateAttempt) values (?, ?, ?)";
        try {
            PreparedStatement statement = con.prepareStatement(querry);
            statement.setString(1, quizName);
            statement.setDouble(2, mark);
            statement.setTimestamp(3, Timestamp.valueOf(dateAttempt));
            rowInserted = statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}