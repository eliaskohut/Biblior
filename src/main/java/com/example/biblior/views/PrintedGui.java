package com.example.biblior.views;

import com.example.biblior.entities.*;
import com.example.biblior.repositories.PrintedRepository;
import com.example.biblior.service.PrintedService;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@PageTitle("Printed Manager | Biblior")
@Route(value="printedmanager")
public class PrintedGui extends VerticalLayout {
    private PrintedRepository printedRepository;
    private PrintedService printedService;
    private Select<String> selectPrintedType;
    private TextField textFieldArticleField;
    private Select<String> selectBookGenre;
    private TextField textFieldNewspaperCountry;
    private TextField textFieldAuthor;
    private TextField textFieldTitle;
    private IntegerField integerFieldPages;
    private IntegerField integerFieldQuantity;
    private NumberField numberFieldFeePrice;
    private IntegerField integerFieldYearOfPublicaton;
    private Button buttonAddPrinted;
    private Grid<Article> articleGrid;
    private Grid<Book> bookGrid;
    private Grid<Newspaper> newspaperGrid;
    FormLayout printedFormLayout = new FormLayout();

    @Autowired
    public PrintedGui(PrintedRepository printedRepository, PrintedService printedService) {
        this.printedRepository = printedRepository;
        this.printedService = printedService;
        addClassName("printed-manager");
        setSizeFull();
        add(new H3("Printed Manager"));

        buttonAddPrinted = new Button("Add");
        buttonAddPrinted.setEnabled(false);
        buttonAddPrinted.addClickShortcut(Key.ENTER);
        buttonAddPrinted.setSizeFull();

        selectPrintedType = new Select<>();
        selectPrintedType.setLabel("Choose the printed type");
        selectPrintedType.setItems("Article", "Book", "Newspaper");
        selectPrintedType.setEmptySelectionAllowed(false);
        selectPrintedType.setRequiredIndicatorVisible(true);
        selectPrintedType.setAutofocus(true);


        textFieldAuthor = new TextField("Author");
        textFieldAuthor.setRequired(true);
        textFieldAuthor.setClearButtonVisible(true);
        textFieldAuthor.setMaxLength(64);
        textFieldAuthor.addValueChangeListener(event -> {
            if (textFieldAuthor.isInvalid()) {
                errorNotificationThrow("Enter author");
                buttonAddPrinted.setEnabled(false);
            }
        });


        textFieldTitle = new TextField("Title");
        textFieldTitle.setRequired(true);
        textFieldTitle.setClearButtonVisible(true);
        textFieldTitle.setMaxLength(64);
        textFieldTitle.addValueChangeListener(event -> {
            if (textFieldTitle.isInvalid()) {
                errorNotificationThrow("Enter title");
                buttonAddPrinted.setEnabled(false);
            }
        });


        integerFieldYearOfPublicaton = new IntegerField();
        integerFieldYearOfPublicaton.setLabel("Year of publication");
        integerFieldYearOfPublicaton.setValue(2022);
        integerFieldYearOfPublicaton.setRequiredIndicatorVisible(true);
        integerFieldYearOfPublicaton.setMax(Calendar.getInstance().get(Calendar.YEAR));
        integerFieldYearOfPublicaton.setErrorMessage("Max " + Calendar.getInstance().get(Calendar.YEAR));
        integerFieldYearOfPublicaton.addValueChangeListener(event -> {
            if (integerFieldYearOfPublicaton.isInvalid() || integerFieldYearOfPublicaton.getValue() == null) {
                buttonAddPrinted.setEnabled(false);
            }
        });


        integerFieldPages = new IntegerField();
        integerFieldPages.setLabel("Pages");
        integerFieldPages.setHelperText("Enter the number of pages");
        integerFieldPages.setMin(1);
        integerFieldPages.setValue(1);
        integerFieldPages.setRequiredIndicatorVisible(true);
        integerFieldPages.setErrorMessage("The number of pages cannot be negative");
        integerFieldPages.addValueChangeListener(event -> {
            if (integerFieldPages.isInvalid() || integerFieldPages.getValue() == null) {
                buttonAddPrinted.setEnabled(false);
            }
        });


        integerFieldQuantity = new IntegerField();
        integerFieldQuantity.setLabel("Quantity");
        integerFieldQuantity.setMin(1);
        integerFieldQuantity.setStep(1);
        integerFieldQuantity.setRequiredIndicatorVisible(true);
        integerFieldQuantity.setValue(1);
        integerFieldQuantity.setHasControls(true);
        integerFieldQuantity.setErrorMessage("The number of printed cannot be negative");
        integerFieldQuantity.addValueChangeListener(event -> {
            if (integerFieldQuantity.isInvalid() || integerFieldQuantity.getValue() == null) {
                buttonAddPrinted.setEnabled(false);
            }
        });

        numberFieldFeePrice = new NumberField();
        numberFieldFeePrice.setLabel("Fee price");
        numberFieldFeePrice.setValue(1d);
        numberFieldFeePrice.setMin(0);
        numberFieldFeePrice.setRequiredIndicatorVisible(true);
        Div dollarPrefix = new Div();
        dollarPrefix.setText("$");
        numberFieldFeePrice.setPrefixComponent(dollarPrefix);
        numberFieldFeePrice.setErrorMessage("The price cannot be negative");
        numberFieldFeePrice.addValueChangeListener(event -> {
            if (numberFieldFeePrice.isInvalid() || numberFieldFeePrice.getValue() == null) {
                buttonAddPrinted.setEnabled(false);
            }
        });


        printedFormLayout.add(
                selectPrintedType, textFieldTitle, textFieldAuthor, integerFieldYearOfPublicaton,
                integerFieldPages, numberFieldFeePrice, integerFieldQuantity
        );

        articleGrid = new Grid<>(Article.class);
        bookGrid = new Grid<>(Book.class);
        newspaperGrid = new Grid<>(Newspaper.class);
        add(printedFormLayout);


        selectPrintedType.addValueChangeListener(change -> selectPrintedTypeEvent());


        buttonAddPrinted.addClickListener(click -> {
            successNotification(selectPrintedType.getValue() + " successfully added");
            addPrinted();
            updatePrintedList();
            nullify();
        });

        add(new H3("Articles"), articleGrid, new H3("Books"), bookGrid, new H3("Newspaper"), newspaperGrid);
        configureGrid();
        updatePrintedList();

    }

    private void updatePrintedList() {
        try{
            articleGrid.setItems(printedService.getAllArticles());
            bookGrid.setItems(printedService.getAllBooks());
            newspaperGrid.setItems(printedService.getAllNewspapers());
        }catch (NullPointerException ignore){}
    }

    private void configureGrid() {
        articleGrid.addClassName("article-grid");
        articleGrid.setSizeFull();
        articleGrid.setColumns("author", "title", "field", "yearOfPublication", "pages", "feePrice", "quantity", "borrowedBy");
        articleGrid.getColumns().forEach(column -> column.setAutoWidth(true));
        articleGrid.setMinHeight("500px");
        bookGrid.addClassName("book-grid");
        bookGrid.setSizeFull();
        bookGrid.setColumns("author", "title", "genre", "yearOfPublication", "pages", "feePrice", "quantity", "borrowedBy");
        bookGrid.getColumns().forEach(column -> column.setAutoWidth(true));
        bookGrid.setMinHeight("500px");
        newspaperGrid.addClassName("newspaper-grid");
        newspaperGrid.setSizeFull();
        newspaperGrid.setColumns("author", "title", "country", "yearOfPublication", "pages", "feePrice", "quantity", "borrowedBy");
        newspaperGrid.getColumns().forEach(column -> column.setAutoWidth(true));
        newspaperGrid.setMinHeight("500px");
    }

    public void addPrinted() {
        if (Objects.equals(selectPrintedType.getValue(), "Article")) {
            printedRepository.save(Article.builder().author(textFieldAuthor.getValue())
                    .title(textFieldTitle.getValue())
                    .yearOfPublication(integerFieldYearOfPublicaton.getValue())
                    .pages(integerFieldPages.getValue())
                    .feePrice(numberFieldFeePrice.getValue())
                    .quantity(integerFieldQuantity.getValue())
                    .field(textFieldArticleField.getValue())
                    .build());
        } else if (Objects.equals(selectPrintedType.getValue(), "Book")) {
            printedRepository.save(Book.builder().author(textFieldAuthor.getValue())
                    .title(textFieldTitle.getValue())
                    .yearOfPublication(integerFieldYearOfPublicaton.getValue())
                    .pages(integerFieldPages.getValue())
                    .feePrice(numberFieldFeePrice.getValue())
                    .quantity(integerFieldQuantity.getValue())
                    .genre(selectBookGenre.getValue())
                    .build());
        } else if (Objects.equals(selectPrintedType.getValue(), "Newspaper")) {
            printedRepository.save(Newspaper.builder().author(textFieldAuthor.getValue())
                    .title(textFieldTitle.getValue())
                    .yearOfPublication(integerFieldYearOfPublicaton.getValue())
                    .pages(integerFieldPages.getValue())
                    .feePrice(numberFieldFeePrice.getValue())
                    .quantity(integerFieldQuantity.getValue())
                    .country(textFieldNewspaperCountry.getValue())
                    .build());
        }
    }

    private void nullify() {
        selectPrintedType.setValue(null);
        textFieldAuthor.setValue("Author");
        textFieldAuthor.setAutofocus(true);
        textFieldTitle.setValue("Title");
        textFieldTitle.focus();
        textFieldTitle.setAutoselect(true);
        integerFieldYearOfPublicaton.setValue(null);
        integerFieldPages.setValue(1);
        numberFieldFeePrice.setValue(1d);
        integerFieldQuantity.setValue(1);
    }

    private void successNotification(String message) {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);

        Div text = new Div(new Text(message));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(click -> notification.close());

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);
        notification.add(layout);
        notification.open();
    }

    private void errorNotificationThrow(String errorMessage) {
        Notification notification = new Notification();
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);

        Div text = new Div(new Text(errorMessage));

        Button closeButton = new Button(new Icon("lumo", "cross"));
        closeButton.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
        closeButton.getElement().setAttribute("aria-label", "Close");
        closeButton.addClickListener(click -> notification.close());

        HorizontalLayout layout = new HorizontalLayout(text, closeButton);
        layout.setAlignItems(Alignment.CENTER);
        notification.setDuration(4);
        notification.add(layout);
        notification.open();
    }

    private void selectPrintedTypeEvent() {
        try {
            printedFormLayout.remove(textFieldArticleField);
        } catch (NullPointerException ignore) {
        }
        try {
            printedFormLayout.remove(textFieldNewspaperCountry);
        } catch (NullPointerException ignore) {
        }
        try {
            printedFormLayout.remove(selectBookGenre);
        } catch (NullPointerException ignore) {
        }
        try {
            printedFormLayout.remove(buttonAddPrinted);
        } catch (NullPointerException ignore) {
        }
        if (Objects.equals(selectPrintedType.getValue(), "Article")) {
            textFieldArticleField = new TextField("Article field");
            textFieldArticleField.setRequired(true);
            printedFormLayout.add(textFieldArticleField);
            printedFormLayout.add(buttonAddPrinted);
            printedFormLayout.setColspan(buttonAddPrinted, 2);
            textFieldArticleField.addValueChangeListener(event -> {
                while (!buttonAddPrinted.isEnabled() || textFieldAuthor.isInvalid() || textFieldTitle.isInvalid()) {
                    try {
                        if (!textFieldAuthor.isInvalid() && !textFieldTitle.isInvalid()) {
                            buttonAddPrinted.setEnabled(true);
                        }
                    } catch (NullPointerException e) {
                        errorNotificationThrow("Fill the required fields");
                    }
                }
            });
        } else if (Objects.equals(selectPrintedType.getValue(), "Book")) {
            selectBookGenre = new Select<>();
            selectPrintedType.setEmptySelectionAllowed(false);
            selectBookGenre.setRequiredIndicatorVisible(true);
            selectBookGenre.setLabel("Book genre");
            selectBookGenre.setItems(Stream.of(Genre.values()).map(Genre::enumFormat).collect(Collectors.toList()));
            printedFormLayout.add(selectBookGenre);
            printedFormLayout.add(buttonAddPrinted);
            printedFormLayout.setColspan(buttonAddPrinted, 2);
            selectBookGenre.addValueChangeListener(event -> {
                while (!buttonAddPrinted.isEnabled() || textFieldAuthor.isInvalid() || textFieldTitle.isInvalid()) {
                    try {
                        if (!textFieldAuthor.isInvalid() && !textFieldTitle.isInvalid()) {
                            buttonAddPrinted.setEnabled(true);
                        }
                    } catch (NullPointerException e) {
                        errorNotificationThrow("Fill the required fields");
                    }
                }
            });
        } else if (Objects.equals(selectPrintedType.getValue(), "Newspaper")) {
            textFieldNewspaperCountry = new TextField("Country");
            textFieldNewspaperCountry.setRequired(true);
            printedFormLayout.add(textFieldNewspaperCountry);
            printedFormLayout.add(buttonAddPrinted);
            printedFormLayout.setColspan(buttonAddPrinted, 2);
            textFieldNewspaperCountry.addValueChangeListener(event -> {
                while (!buttonAddPrinted.isEnabled() || textFieldAuthor.isInvalid() || textFieldTitle.isInvalid()) {
                    try {
                        if (!textFieldAuthor.isInvalid() && !textFieldTitle.isInvalid()) {
                            buttonAddPrinted.setEnabled(true);
                        }
                    } catch (NullPointerException e) {
                        errorNotificationThrow("Fill the required fields");
                    }
                }
            });
        }else{
            buttonAddPrinted.setEnabled(false);
            try {
                printedFormLayout.remove(textFieldArticleField);
            } catch (NullPointerException ignore) {
            }
            try {
                printedFormLayout.remove(textFieldNewspaperCountry);
            } catch (NullPointerException ignore) {
            }
            try {
                printedFormLayout.remove(selectBookGenre);
            } catch (NullPointerException ignore) {
            }
            try {
                printedFormLayout.remove(buttonAddPrinted);
            } catch (NullPointerException ignore) {
            }
        }
    }
}
