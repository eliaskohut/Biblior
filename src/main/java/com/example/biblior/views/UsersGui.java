package com.example.biblior.views;

import com.example.biblior.entities.*;
import com.example.biblior.repositories.UserRepository;
import com.example.biblior.service.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

@PageTitle("User Manager | Biblior")
@Route(value="usermanager")
@AnonymousAllowed
public class UsersGui extends VerticalLayout {
    private final UserRepository userRepository;
    private final UserService userService;
    private final Select<String> selectUserType = new Select<>();
    TextField firstName = new TextField("First name");
    TextField lastName = new TextField("Last name");
    EmailField email = new EmailField("Email");
    PasswordField password = new PasswordField("Password");
    PasswordField confirmPassword = new PasswordField("Confirm password");
    FormLayout formLayout = new FormLayout();
    Grid<Admin> admins = new Grid<>(Admin.class);
    Grid<Librarian> librarians = new Grid<>(Librarian.class);
    Grid<WarehouseWorker> warehouseWorkers = new Grid<>(WarehouseWorker.class);
    Grid<Reader> readers = new Grid<>(Reader.class);
    Button addUser;

    @Autowired
    public UsersGui(UserRepository userRepository, UserService userService){
        this.userRepository = userRepository;
        this.userService = userService;
        firstName.setRequired(true);
        firstName.setMinLength(2);
        firstName.setErrorMessage("Name must be longer");
        firstName.setInvalid(true);
        firstName.addValueChangeListener(change -> addUserCheck());
        lastName.setRequired(true);
        lastName.setMinLength(2);
        lastName.setErrorMessage("Last name must be longer");
        lastName.addValueChangeListener(change -> addUserCheck());
        lastName.setInvalid(true);
        email.setRequiredIndicatorVisible(true);
        email.setPlaceholder("username@example.com");
        email.setClearButtonVisible(true);
        email.addValueChangeListener(change -> addUserCheck());
        email.setInvalid(true);
        password.setRequired(true);
        password.addValueChangeListener(change -> addUserCheck());
        password.setInvalid(true);
        confirmPassword.setRequired(true);
        confirmPassword.addValueChangeListener(change -> {
            confirmPassword.setErrorMessage("Repeat your password");
            addUserCheck();
            if (!Objects.equals(confirmPassword.getValue(), password.getValue())){
                addUser.setEnabled(false);
                confirmPassword.setErrorMessage("Values do not match");
            }
        });
        confirmPassword.setInvalid(true);
        selectUserType.setLabel("User type");
        selectUserType.setItems("Admin", "Reader", "Librarian", "Warehouse worker");
        selectUserType.setEmptySelectionAllowed(false);
        selectUserType.setRequiredIndicatorVisible(true);
        selectUserType.setAutofocus(true);
        selectUserType.addValueChangeListener(change -> {
            addUserCheck();
            selectUserType.setInvalid(false);
            if(!confirmPassword.getValue().equals(password.getValue()) ||
                    (confirmPassword.getValue()==null || password.getValue()==null)){
                addUser.setEnabled(false);
            }
        });
        selectUserType.setInvalid(true);
        add(new H3("User Manager"));
        addUser = new Button("Add");
        HorizontalLayout footer = new HorizontalLayout(addUser);
        addUser.setSizeFull();
        addUser.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        footer.getStyle().set("flex-wrap", "wrap");
        setAlignItems(Alignment.STRETCH);
        formLayout.add(
                firstName, lastName,
                email, selectUserType,
                password, confirmPassword,
                footer
        );
        addUser.addClickListener(click -> {
            addUserEvent();
            updateUserList();
            nullify();
        });
        formLayout.setColspan(footer, 2);
        add(formLayout);
        configureGrid();
        addUser.setEnabled(false);
    }

    private void nullify() {
        firstName.setValue("");
        lastName.setValue("");
        email.setValue("");
        selectUserType.setValue(null);
        selectUserType.setInvalid(true);
        password.setValue("");
        confirmPassword.setValue("");
    }

    private void addUserCheck() {
            if(firstName.isInvalid() || firstName.getValue()==null){
                addUser.setEnabled(false);
            }else if(lastName.isInvalid() || lastName.getValue()==null){
                addUser.setEnabled(false);
            }else if(email.isInvalid() || email.getValue()==null){
                addUser.setEnabled(false);
            }else if(selectUserType.isInvalid() || selectUserType.getValue()==null){
                addUser.setEnabled(false);
            }else if(password.isInvalid() || password.getValue()==null){
                addUser.setEnabled(false);
            }else if(confirmPassword.isInvalid() || confirmPassword.getValue()==null){
                addUser.setEnabled(false);
            }else{
                addUser.setEnabled(true);
            }
    }

    private void addUserEvent() {
        if(Objects.equals(selectUserType.getValue(), "Admin")){
            userRepository.save(Admin.builder()
                            .email(email.getValue())
                            .firstName(firstName.getValue())
                            .lastName(lastName.getValue())
                            .password(password.getValue())
                    .build());
        }else if(Objects.equals(selectUserType.getValue(), "Reader")){
            userRepository.save(Reader.builder()
                    .email(email.getValue())
                    .firstName(firstName.getValue())
                    .lastName(lastName.getValue())
                    .password(password.getValue())
                    .build());
        }else if(Objects.equals(selectUserType.getValue(), "Warehouse worker")){
            userRepository.save(WarehouseWorker.builder()
                    .email(email.getValue())
                    .firstName(firstName.getValue())
                    .lastName(lastName.getValue())
                    .password(password.getValue())
                    .build());
        }else if(Objects.equals(selectUserType.getValue(), "Librarian")){
            userRepository.save(Librarian.builder()
                    .email(email.getValue())
                    .firstName(firstName.getValue())
                    .lastName(lastName.getValue())
                    .password(password.getValue())
                    .build());
        }
    }

    private void configureGrid() {
        gridColumns(admins);
        gridColumns(readers);
        gridColumns(librarians);
        gridColumns(warehouseWorkers);
        gridFormat(admins, "Admins");
        gridFormat(readers, "Readers");
        gridFormat(librarians, "Librarians");
        gridFormat(warehouseWorkers, "Warehouse workers");
        updateUserList();
    }
    private void gridColumns(Grid<? extends User> grid){
        grid.setColumns("firstName", "lastName", "email", "failedBorrows");
        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        grid.setMinHeight("500px");
        grid.setSizeFull();
    }
    private void gridFormat(Grid<? extends User> grid, String name){
        Button deleteButton = new Button("Delete");
        deleteButton.setEnabled(false);
        HorizontalLayout footer = new HorizontalLayout(deleteButton);
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        footer.getStyle().set("flex-wrap", "wrap");
        setAlignItems(Alignment.STRETCH);
        add(new H3(name), grid);
        if(!grid.getClass().getSimpleName().equals("admins")){
            add(footer);
        }
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addSelectionListener(selection -> {
            deleteButton.setEnabled(true);
            if(selection.getAllSelectedItems().size() == 0){
                deleteButton.setEnabled(false);
            }
            deleteButton.addClickListener(click -> {
                selection.getAllSelectedItems().forEach(userService::deleteUser);
                deleteButton.setEnabled(false);
                updateUserList();
            });
        });
    }
    private void updateUserList() {
        try{
            admins.setItems(userService.getAllAdmins());
            readers.setItems(userService.getAllReaders());
            librarians.setItems(userService.getAllLibrarians());
            warehouseWorkers.setItems(userService.getAllWarehouseWorkers());
        }catch (NullPointerException ignore){}
    }
}
