/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author MarcoMan
 * Channel: https://www.youtube.com/channel/UCPgcmw0LXToDn49akUEJBkQ
 * Please support our channel (SUBSCRIBE --> TURN ON NOTIFICATION -->
 * HIT THE LIKE BUTTON)
 */
public class dashboardController implements Initializable {

    @FXML
    private AnchorPane AddBooksAnchorPane;

    @FXML
    private AnchorPane StudentIDAnchorpanrForm;

    @FXML
    private TextArea addressSform;

    @FXML
    private Button close;

    @FXML
    private Button minimize;

    @FXML
    private Button bars_btn;
    @FXML
    private Button btnSubmitID;

    @FXML
    private Button arrow_btn;

    @FXML
    private AnchorPane nav_form;

    @FXML
    private Circle circle_image;

    @FXML
    private Label studentNumber_label;

    @FXML
    private Button availableBooks_btn;

    @FXML
    private Button issueBooks_btn;

    @FXML
    private Button returnBooks_btn;

    @FXML
    private Button btnNew;

    @FXML
    private Button savedBooks_btn;

    @FXML
    private Button edit_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button btnAddBform;

    @FXML
    private Button btnAddStudent;

    @FXML
    private Button btnAddBook;

    @FXML
    private Button btnCreateSform;

    @FXML
    private Button btnSelectImageB;

    @FXML
    private TableView<getStudentData> Student_tableView;

    @FXML
    private TableColumn<getStudentData, String> colAddressS;
    @FXML
    private TableColumn<getStudentData, String> colBirthDate;

    @FXML
    private TableColumn<getStudentData, String> colContactS;
    @FXML
    private TableColumn<getStudentData, String> colfirstnameS;

    @FXML
    private TableColumn<getStudentData, String> colDateS;

    @FXML
    private TableColumn<getStudentData, String> collasnameS;
    @FXML
    private TableColumn<getStudentData, String> colEmailS;

    @FXML
    private TableColumn<getStudentData, String> colGenderS;

    @FXML
    private TableColumn<getStudentData, String> colIDNumberS;

    @FXML
    private TableColumn<getStudentData, String> colStudentTypeS;

    @FXML
    private TableView<availableBooks> AddBook_tableView;
    @FXML
    private TableColumn<availableBooks, String> colTitleB;
    @FXML
    private TableColumn<availableBooks, String> colAuthorB;
    @FXML
    private TableColumn<availableBooks, String> colGenreB;
    @FXML
    private TableColumn<availableBooks, String> colImageB;
    @FXML
    private TableColumn<availableBooks, String> colDatesB;

    @FXML
    private TextField contactSform;
    @FXML
    private TextField emailSform;
    @FXML
    private TextField tfSearch;

    @FXML
    private TextField firstnameSform;

    @FXML
    private ComboBox<?> genderSform;
    @FXML
    private DatePicker birthDateSForm;
    @FXML
    private ComboBox<?> studentTyoeSform;

    @FXML
    private TextField idnumberSform;

    @FXML
    private TextField lastnameSform;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfGenre;

    @FXML
    private TextField tfImageB;

    @FXML
    private TextField tfTitleB;

    @FXML
    private AnchorPane availableBooks_form;
    @FXML
    private AnchorPane Student_AnchorPaneForm;

    @FXML
    private TableView<availableBooks> availableBooks_tableView;

    @FXML
    private TableColumn<availableBooks, String> col_ab_bookTitle;

    @FXML
    private TableColumn<availableBooks, String> col_ab_author;

    @FXML
    private TableColumn<availableBooks, String> col_ab_bookType;

    @FXML
    private TableColumn<availableBooks, String> col_ab_publishedDate;

    @FXML
    private ImageView availableBooks_imageView;

    @FXML
    private Button save_btn;

    @FXML
    private Label availableBooks_title;

    @FXML
    private Button take_btn;

    @FXML
    private AnchorPane halfNav_form;

    @FXML
    private Circle smallCircle_image;

    @FXML
    private Button halfNav_availableBtn;

    @FXML
    private Button halfNav_takeBtn;

    @FXML
    private Button halfNav_returnBtn;

    @FXML
    private Button halfNav_saveBtn;

    @FXML
    private AnchorPane mainCenter_form;

    @FXML
    private AnchorPane issue_form;

    @FXML
    private AnchorPane returnBook_form;

    @FXML
    private AnchorPane savedBook_form;

    @FXML
    private Label currentForm_label;

    // @FXML
    // private TextField take_StudentNumber;
    @FXML
    private Label take_StudentNumber;

    @FXML
    private TextField take_FirstName;

    @FXML
    private TextField tfstudentIDNumber;

    @FXML
    private TextField take_LastName;

    @FXML
    private ComboBox<?> take_Gender;

    @FXML
    private TextField take_BookTitle;

    @FXML
    private Label take_IssuedDate;

    @FXML
    private ImageView take_imageView;

    @FXML
    private Label take_titleLabel;

    @FXML
    private Label take_authorLabel;

    @FXML
    private Label take_genreLabel;

    @FXML
    private Label take_dateLabel;

    @FXML
    private Button take_clearBtn;

    @FXML
    private Button take_takeBtn;

    @FXML
    private TableView<returnBook> return_tableView;

    @FXML
    private TableColumn<returnBook, String> col_return_BookTitle;

    @FXML
    private TableColumn<returnBook, String> col_return_Author;

    @FXML
    private TableColumn<returnBook, String> col_return_bookType;

    @FXML
    private TableColumn<returnBook, String> col_return_dateIssue;

    @FXML
    private ImageView return_imageView;

    @FXML
    private Button return_button;

    @FXML
    private Label returnBookTitle;

    @FXML
    private TableView<saveBook> save_tableView;

    @FXML
    private TableColumn<saveBook, String> col_saveTitle;

    @FXML
    private TableColumn<saveBook, String> col_saveAuthor;

    @FXML
    private TableColumn<saveBook, String> col_saveGenre;

    @FXML
    private TableColumn<saveBook, String> col_saveDate;

    @FXML
    private ImageView save_imageView;

    @FXML
    private Button unsaveBtn;

    // @FXML
    // private FontAwesomeIcon edit_icon;

    @FXML
    void onclickSearch(ActionEvent event) {

    }

    public ObservableList<getStudentData> studentListss() {

        ObservableList<getStudentData> studentdataList = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student ";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            getStudentData studentsList;

            while (result.next()) {
                studentsList = new getStudentData(result.getString("idnumber"),
                        result.getString("firstname"),
                        result.getString("lastname"),
                        result.getString("birthdate"),
                        result.getString("gender"),
                        result.getString("address"),
                        result.getString("email"),
                        result.getString("contact"),
                        result.getString("type"));

                studentdataList.add(studentsList);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return studentdataList;

    }

    private ObservableList<getStudentData> studentLists;

    public void studentListData() {
        studentLists = studentListss();

        colIDNumberS.setCellValueFactory(new PropertyValueFactory<>("idnumber"));
        colfirstnameS.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        collasnameS.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        colBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthdate"));
        colGenderS.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colAddressS.setCellValueFactory(new PropertyValueFactory<>("address"));
        colEmailS.setCellValueFactory(new PropertyValueFactory<>("email"));
        colContactS.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colStudentTypeS.setCellValueFactory(new PropertyValueFactory<>("type"));
        // colDateS.setCellValueFactory(new PropertyValueFactory<>("dates"));

        Student_tableView.setItems(studentLists);

    }

    public void addAvailableBookSearch() {

        FilteredList<availableBooks> filter = new FilteredList<>(listBook, e -> true);

        tfSearch.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateAvailableBookData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();
                if (predicateAvailableBookData.getTitle().toString().contains(searchKey)) {
                    return true;
                } else if (predicateAvailableBookData.getAuthor().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateAvailableBookData.getGenre().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateAvailableBookData.getDate().toString().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<availableBooks> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(availableBooks_tableView.comparatorProperty());
        availableBooks_tableView.setItems(sortList);
    }

    @FXML
    void onBtnSubmitID(ActionEvent event) {
        String sql = "SELECT * FROM student WHERE idnumber = ? ";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, tfstudentIDNumber.getText());
            // prepare.setString(2, password.getText());
            result = prepare.executeQuery();
            // String user = tfstudentIDNumber.getText();
            Alert alert;
            if (tfstudentIDNumber.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                // alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields.");
                alert.showAndWait();

            } else {
                if (result.next()) {
                    getData.studentNumber = tfstudentIDNumber.getText();
                    take_StudentNumber.setText(getData.studentNumber);

                    take_FirstName.setText(result.getString("firstname") + " " + result.getString("lastname"));

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully!");
                    alert.show();
                    // TO HIDE THE LOGIN FORM

                    // FOR DASHBOARD
                    result.close();

                    StudentIDAnchorpanrForm.setVisible(false);
                    availableBooks_form.setVisible(true);
                    // Button mutable
                    savedBooks_btn.setDisable(false);
                    availableBooks_btn.setDisable(false);
                    issueBooks_btn.setDisable(false);
                    returnBooks_btn.setDisable(false);
                    currentForm_label.setText("Available Books");
                    addAvailableBookSearch();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Admin Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong ID Number");
                    alert.showAndWait();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // StudentIDAnchorpanrForm.setVisible(false);
        // availableBooks_form.setVisible(true);
        // // Button mutable
        // savedBooks_btn.setDisable(false);
        // availableBooks_btn.setDisable(false);
        // issueBooks_btn.setDisable(false);
        // returnBooks_btn.setDisable(false);
        // currentForm_label.setText("Available Books");
    }

    @FXML
    void onBtnHome(ActionEvent event) {
        issue_form.setVisible(false);
        availableBooks_form.setVisible(false);
        StudentIDAnchorpanrForm.setVisible(false);
        savedBook_form.setVisible(false);
        returnBook_form.setVisible(false);
        AddBooksAnchorPane.setVisible(false);
        Student_AnchorPaneForm.setVisible(false);
        StudentIDAnchorpanrForm.setVisible(true);
        // Button mutable
        savedBooks_btn.setDisable(true);
        availableBooks_btn.setDisable(true);
        issueBooks_btn.setDisable(true);
        returnBooks_btn.setDisable(true);

    }

    @FXML
    void onBtnAddStudent(ActionEvent event) {
        navButtonDesign(event);
        studentListData();
    }

    @FXML
    void onBtnAddBook(ActionEvent event) {
        navButtonDesign(event);
        showAvailableBooks();

    }

    @FXML
    private ImageView bookImage;

    @FXML
    void onBtnSelectImageB(ActionEvent event) {
        FileChooser open = new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image file", "*png", "*jpg"));
        Stage stage = (Stage) nav_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {
            getData.path = file.getAbsolutePath();
            String uri = "file:" + getData.path;
            image = new Image(uri, 127, 162, false, true);
            // take_imageView.setImage(image);
            bookImage.setImage(image);

            // copyFile(sourFile.toPath(), destFile.toPath());
            tfImageB.setText(uri);
            // System.out.println(getData.path);
        }
    }

    @FXML
    void onbtnCreateSform(ActionEvent event) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (idnumberSform.getText().isEmpty() || firstnameSform.getText().isEmpty()
                    || lastnameSform.getText().isEmpty()
                    || genderSform.getSelectionModel().isEmpty()
                    || addressSform.getText().isEmpty()
                    || emailSform.getText().isEmpty()
                    || contactSform.getText().isEmpty()
                    || studentTyoeSform.getSelectionModel().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please type complete Student Details");
                alert.showAndWait();
            } else {

                LocalDate bds = birthDateSForm.getConverter().fromString(birthDateSForm.getEditor().getText());
                String bd = bds.toString();
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, idnumberSform.getText());
                prepare.setString(2, firstnameSform.getText());
                prepare.setString(3, lastnameSform.getText());
                prepare.setString(4, bd);
                // prepare.setString(4, birthDateSForm.getValue().toString());
                prepare.setString(5, (String) genderSform.getSelectionModel().getSelectedItem());
                prepare.setString(6, addressSform.getText());
                prepare.setString(7, emailSform.getText());
                prepare.setString(8, contactSform.getText());
                prepare.setString(9, (String) studentTyoeSform.getSelectionModel().getSelectedItem());

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully!");
                alert.showAndWait();


                // clear Data input
                idnumberSform.setText("");
                firstnameSform.setText("");
                lastnameSform.setText("");
                genderSform.getSelectionModel().clearSelection();
                addressSform.setText("");
                emailSform.setText("");
                contactSform.setText("");
                studentTyoeSform.getSelectionModel().clearSelection();
                studentListData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onBtnAddB(ActionEvent event) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO book VALUES (?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (tfTitleB.getText().isEmpty() || tfAuthor.getText().isEmpty()
                    || tfGenre.getText().isEmpty()
                    || tfImageB.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please type complete Student Details");
                alert.showAndWait();
            } else {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, tfTitleB.getText());
                prepare.setString(2, tfAuthor.getText());
                prepare.setString(3, tfGenre.getText());
                prepare.setString(4, tfImageB.getText());
                prepare.setDate(5, sqlDate);
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully");
                alert.showAndWait();
                showAvailableBooks();
                // clearTakeData();
                tfTitleB.setText("");
                tfAuthor.setText("");
                tfGenre.setText("");
                tfImageB.setText("");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Image image;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private String comboBoxGender[] = {"Male", "Female", "Others"};
    private String comboBoxStudent[] = {"Reguler", "Part-Time", "Master", "Phd"};

    public void gender() {
    }

    public void genderStudentType() {

        List<String> combo = new ArrayList<>();

        for (String data : comboBoxGender) {

            combo.add(data);
        }
        List<String> combo2 = new ArrayList<>();

        for (String data : comboBoxStudent) {

            combo2.add(data);
        }

        ObservableList list = FXCollections.observableList(combo);
        ObservableList list2 = FXCollections.observableList(combo2);

        // take_Gender.setItems(list);
        genderSform.setItems(list);
        studentTyoeSform.setItems(list2);

    }

    public void takeBook() {

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "INSERT INTO take VALUES (?,?,?,?,?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;
            if (take_titleLabel.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the book you want to take.");
                alert.showAndWait();
            } else {

                prepare = connect.prepareStatement(sql);
                prepare.setString(1, take_StudentNumber.getText());
                prepare.setString(2, take_FirstName.getText());
                prepare.setString(3, "not Needed");
                prepare.setString(4, "Not Needed");
                prepare.setString(5, take_titleLabel.getText());
                prepare.setString(6, take_authorLabel.getText());
                prepare.setString(7, take_genreLabel.getText());
                prepare.setString(8, getData.path);
                prepare.setDate(9, sqlDate);

                String check = "Not Return";

                prepare.setString(10, check);
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successful!y take the book!");
                alert.showAndWait();

                clearTakeData();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void findBook() {

        clearFindData();

        String sql = "SELECT * FROM book WHERE title = '" + take_BookTitle.getText() + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            boolean check = false;

            Alert alert;

            if (take_BookTitle.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book.");
                alert.showAndWait();

            } else {

                while (result.next()) {

                    take_titleLabel.setText(result.getString("title"));
                    take_authorLabel.setText(result.getString("author"));
                    take_genreLabel.setText(result.getString("genre"));
                    take_dateLabel.setText(result.getString("dates"));

                    getData.path = result.getString("image");

                    String uri = getData.path;

                    image = new Image(uri, 127, 162, false, true);
                    take_imageView.setImage(image);

                    check = true;
                }

                if (!check) {
                    take_titleLabel.setText("Book is not available!");

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void studentNumberLabel() {
        take_StudentNumber.setText(getData.studentNumber);
    }

    public void clearTakeData() {

        take_BookTitle.setText("");
        take_StudentNumber.setText("");
        take_FirstName.setText("");
        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_dateLabel.setText("");
        take_imageView.setImage(null);

    }

    public void clearFindData() {

        take_titleLabel.setText("");
        take_authorLabel.setText("");
        take_genreLabel.setText("");
        take_dateLabel.setText("");
        take_imageView.setImage(null);
        // take_FirstName.setText("");

    }

    public void displayDate() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new java.util.Date());

        take_IssuedDate.setText(date);
    }

    // RETURN FORM
    // SORRY, I GOT BUG TO SCENEBUILDER THAT'S WHY I CAN'T RUN THE PROGRAM (ERROR)
    public ObservableList<returnBook> returnBook() {

        ObservableList<returnBook> bookReturnData = FXCollections.observableArrayList();

        String check = "Not Return";

        String sql = "SELECT * FROM take WHERE checkreturn='" + check + "'";

        connect = Database.connectDB();

        try {

            returnBook rBook;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                rBook = new returnBook(result.getString("title"), result.getString("author"),
                        result.getString("genre"), result.getString("path"),
                        result.getDate("date"));
                bookReturnData.add(rBook);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bookReturnData;

    }

    public void returnBooks() {

        String sql = "UPDATE take SET checkreturn = 'Returned' WHERE title = '" + getData.takeBookTitle + "'";

        connect = Database.connectDB();

        Alert alert;

        try {

            if (return_imageView.getImage() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book you want to return");
                alert.showAndWait();

            } else {

                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully returned!");
                alert.showAndWait();

                showBookReturn();

                return_imageView.setImage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    ObservableList<returnBook> retBook;

    public void showBookReturn() {

        retBook = returnBook();

        col_return_BookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_return_Author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_return_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_return_dateIssue.setCellValueFactory(new PropertyValueFactory<>("date"));

        return_tableView.setItems(retBook);

    }

    public void selectReturnBook() {
        try {
            returnBook rBook = return_tableView.getSelectionModel().getSelectedItem();
            int num = return_tableView.getSelectionModel().getFocusedIndex();

            if ((num - 1) < -1) {
                return;
            }

            String uri = rBook.getImage();
            image = new Image(uri);
            return_imageView.setImage(image);

            getData.takeBookTitle = rBook.getTitle();
        } catch (Exception e) {
            // System.out.println(e);
            Alert alert;

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("image Location not found");
            alert.showAndWait();
        }
    }

    public ObservableList<availableBooks> dataList() {

        ObservableList<availableBooks> listBooks = FXCollections.observableArrayList();

        String sql = "SELECT * FROM book";

        connect = Database.connectDB();

        try {

            availableBooks aBooks;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            while (result.next()) {
                aBooks = new availableBooks(result.getString("title"),
                        result.getString("author"), result.getString("genre"),
                        result.getString("image"), result.getDate("dates"));
                listBooks.add(aBooks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listBooks;
    }

    // SAVED BOOKS
    public ObservableList<saveBook> savedBooksData() {

        ObservableList<saveBook> listSaveData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM save WHERE number='" + getData.studentNumber + "'";

        connect = Database.connectDB();

        try {

            // THAT'S IT FOR THIS VIDEO, THANKS FOR WATCHING!!! SUBSCRIBE AND HIT
            // NOTIFICATION TO UPDATE FOR NEW UNIQUE TUTORIALS!!!
            // THANKS! : )

            saveBook sBook;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {

                sBook = new saveBook(result.getString("title"),
                        result.getString("author"),
                        result.getString("genre"),
                        result.getString("image"),
                        result.getDate("date"));

                listSaveData.add(sBook);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listSaveData;
    }

    private ObservableList<saveBook> sBookList;

    public void showSavedBooks() {

        sBookList = savedBooksData();

        col_saveTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_saveAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_saveGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_saveDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        save_tableView.setItems(sBookList);

    }

    public void selectSavedBooks() {
        try {
            saveBook sBook = save_tableView.getSelectionModel().getSelectedItem();
            int num = save_tableView.getSelectionModel().getFocusedIndex();

            if ((num - 1) < -1) {
                return;
            }

            String uri = sBook.getImage();
            image = new Image(uri);
            save_imageView.setImage(image);
            getData.image = sBook.getImage();
            getData.title = sBook.getTitle();

        } catch (Exception e) {
            // System.out.println(e);
            Alert alert;

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("image Location not found");
            alert.showAndWait();
        }

    }

    public void saveBooks() {

        String sql = "INSERT INTO save VALUES (?,?,?,?,?,?)";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (availableBooks_title.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the book");
                alert.showAndWait();
            } else {
                prepare = connect.prepareStatement(sql);
                prepare.setString(1, getData.studentNumber);
                prepare.setString(2, getData.title);
                prepare.setString(3, getData.author);
                prepare.setString(4, getData.genre);
                prepare.setString(5, getData.image);
                prepare.setDate(6, getData.dates);
                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Saved.");
                alert.showAndWait();

                showSavedBooks();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void unsaveBooks() {

        String sql = "DELETE FROM save WHERE title = '" + getData.title + "'"
                + " and number = '" + getData.studentNumber + "'";

        connect = Database.connectDB();

        try {

            Alert alert;

            if (save_imageView.getImage() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Please Select the book you want to unsave");
                alert.showAndWait();

            } else {

                statement = connect.createStatement();
                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Admin Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully unsaved.");
                alert.showAndWait();

                showSavedBooks();

                save_imageView.setImage(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // SHOWING BOOKS DATA
    private ObservableList<availableBooks> listBook;

    public void showAvailableBooks() {

        listBook = dataList();
        col_ab_bookTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        col_ab_author.setCellValueFactory(new PropertyValueFactory<>("author"));
        col_ab_bookType.setCellValueFactory(new PropertyValueFactory<>("genre"));
        col_ab_publishedDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        colTitleB.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthorB.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenreB.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colImageB.setCellValueFactory(new PropertyValueFactory<>("image"));
        colDatesB.setCellValueFactory(new PropertyValueFactory<>("date"));

        availableBooks_tableView.setItems(listBook);
        AddBook_tableView.setItems(listBook);

    }

    public void selectAvailableBooks() throws IOException {
        try {
            availableBooks bookData = availableBooks_tableView.getSelectionModel().getSelectedItem();
            int num = availableBooks_tableView.getSelectionModel().getFocusedIndex();

            if ((num - 1) < -1) {
                return;
            }
            availableBooks_title.setText(bookData.getTitle());
            String uri = bookData.getImage();
            image = new Image(uri);
            availableBooks_imageView.setImage(image);
            take_imageView.setImage(image);
            getData.takeBookTitle = bookData.getTitle();
            take_BookTitle.setText(getData.takeBookTitle);
            getData.title = bookData.getTitle();
            getData.author = bookData.getAuthor();
            getData.genre = bookData.getGenre();
            getData.image = bookData.getImage();
            getData.dates = bookData.getDate();

        } catch (Exception e) {
            // System.out.println(e);
            Alert alert;

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Admin Message");
            alert.setHeaderText(null);
            alert.setContentText("image Location not found");
            alert.showAndWait();
        }

    }

    public void abTakeButton(ActionEvent event) {

        if (event.getSource() == take_btn) {
            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            currentForm_label.setText("Issue Books");
            findBook();

        }
    }

    public void studentNumber() {
        // WE CAN DISPLAY THE STUDENT NUMBER THAT STUDENT USED
        studentNumber_label.setText(getData.studentNumber);
    }

    public void insertImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image file", "*png", "*jpg"));
        Stage stage = (Stage) nav_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);
        if (file != null) {
            image = new Image(file.toURI().toString(), 112, 84, false, true);
            circle_image.setFill(new ImagePattern(image));
            smallCircle_image.setFill(new ImagePattern(image));
            getData.path = file.getAbsolutePath();
            changeProfile();

        }
    }

    public void changeProfile() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE student SET image = '" + uri + "' WHERE number = '" + getData.studentNumber + "'";

        connect = Database.connectDB();

        try {

            statement = connect.createStatement();
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showProfile() {

        String uri = "file:" + getData.path;

        image = new Image(uri, 112, 84, false, true);
        circle_image.setFill(new ImagePattern(image));
        smallCircle_image.setFill(new ImagePattern(image));

    }

    public void sideNavButtonDesign(ActionEvent event) {

        if (event.getSource() == halfNav_availableBtn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(true);

            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);

            currentForm_label.setText("Available Books");

        } else if (event.getSource() == halfNav_takeBtn) {

            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);


            currentForm_label.setText("Issue Books");

        } else if (event.getSource() == halfNav_returnBtn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(true);

            currentForm_label.setText("Return Books");

            showBookReturn();

        } else if (event.getSource() == halfNav_saveBtn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(true);
            returnBook_form.setVisible(false);


            currentForm_label.setText("Saved Books");

        }

    }

    public void navButtonDesign(ActionEvent event) {

        if (event.getSource() == availableBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(true);

            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
            AddBooksAnchorPane.setVisible(false);
            Student_AnchorPaneForm.setVisible(false);
            addAvailableBookSearch();

            currentForm_label.setText("Available Books");

        } else if (event.getSource() == issueBooks_btn) {

            issue_form.setVisible(true);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
            AddBooksAnchorPane.setVisible(false);
            Student_AnchorPaneForm.setVisible(false);


            currentForm_label.setText("Issue Books");

        } else if (event.getSource() == returnBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(true);
            AddBooksAnchorPane.setVisible(false);
            Student_AnchorPaneForm.setVisible(false);


            currentForm_label.setText("Return Books");

            showBookReturn();

        } else if (event.getSource() == savedBooks_btn) {

            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(true);
            returnBook_form.setVisible(false);
            AddBooksAnchorPane.setVisible(false);
            Student_AnchorPaneForm.setVisible(false);
            currentForm_label.setText("Saved Books");
            showSavedBooks();

        } else if (event.getSource() == btnAddStudent) {
            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
            AddBooksAnchorPane.setVisible(false);
            Student_AnchorPaneForm.setVisible(true);
            currentForm_label.setText("Add Student");
            showAvailableBooks();
            studentListData();
            showAvailableBooks();

        } else if (event.getSource() == btnAddBook) {
            issue_form.setVisible(false);
            availableBooks_form.setVisible(false);
            savedBook_form.setVisible(false);
            returnBook_form.setVisible(false);
            Student_AnchorPaneForm.setVisible(false);
            StudentIDAnchorpanrForm.setVisible(false);
            AddBooksAnchorPane.setVisible(true);
            currentForm_label.setText("Add Books");

            showAvailableBooks();
            studentListData();
            showAvailableBooks();

        }
    }

    private double x = 0;
    private double y = 0;

    public void sliderArrow() {

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(-224);

        TranslateTransition slide1 = new TranslateTransition();

        slide1.setDuration(Duration.seconds(.5));
        slide1.setNode(mainCenter_form);
        slide1.setToX(-224 + 90);

        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(0);

        slide.setOnFinished((ActionEvent event) -> {

            arrow_btn.setVisible(false);
            bars_btn.setVisible(true);

        });

        slide2.play();
        slide1.play();
        slide.play();

    }
    // Sugggoooiiii!! : )

    public void sliderBars() {

        TranslateTransition slide = new TranslateTransition();

        slide.setDuration(Duration.seconds(.5));
        slide.setNode(nav_form);
        slide.setToX(0);

        TranslateTransition slide1 = new TranslateTransition();

        slide1.setDuration(Duration.seconds(.5));
        slide1.setNode(mainCenter_form);
        slide1.setToX(0);

        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(.5));
        slide2.setNode(halfNav_form);
        slide2.setToX(-77);

        slide.setOnFinished((ActionEvent event) -> {

            arrow_btn.setVisible(true);
            bars_btn.setVisible(false);

        });

        slide2.play();
        slide1.play();
        slide.play();
    }

    @FXML
    public void logout(ActionEvent event) {
        try {
            if (event.getSource() == logout_btn) {
                // TO SWAP FROM DASHBOARD TO LOGIN FORM
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Stage stage = new Stage();
                Scene scene = new Scene(root);

                root.setOnMousePressed((MouseEvent e) -> {
                    x = e.getSceneX();
                    y = e.getSceneY();
                });

                root.setOnMouseDragged((MouseEvent e) -> {

                    stage.setX(e.getScreenX() - x);
                    stage.setY(e.getScreenY() - y);

                });

                stage.initStyle(StageStyle.TRANSPARENT);

                stage.setScene(scene);
                stage.show();

                logout_btn.getScene().getWindow().hide();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit() {

        System.exit(0);

    }

    public void minimize() {

        Stage stage = (Stage) minimize.getScene().getWindow();
        stage.setIconified(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        savedBooks_btn.setDisable(true);
        availableBooks_btn.setDisable(true);
        issueBooks_btn.setDisable(true);
        returnBooks_btn.setDisable(true);
        // designInserImage();

        // showProfile();
        // addAvailableBookSearch();
        // // TO SHOW THE AVAILABLE BOOKS
        studentListData();

        showAvailableBooks();

        studentNumber();

        studentNumberLabel();

        displayDate();

        genderStudentType();

        showSavedBooks();

        studentListss();
        // RETURN FORM
        try {
            showBookReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
