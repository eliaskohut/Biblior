package com.example.biblior.views;

import com.example.biblior.entities.Article;
import com.example.biblior.entities.Book;
import com.example.biblior.entities.Newspaper;
import com.example.biblior.entities.Printed;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Catalogue | Biblior")
@AnonymousAllowed
public class CatalogueView extends VerticalLayout {
    Grid<Book> books = new Grid<>(Book.class);
    Grid<Article> articles = new Grid<>(Article.class);
    Grid<Newspaper> newspapers = new Grid<>(Newspaper.class);

    @Autowired
    public CatalogueView() {

    }

    private void gridConfigure(){
        articles.setColumns("author", "title", "field", "yearOfPublication", "pages", "quantity");
        books.setColumns("author", "title", "field", "yearOfPublication", "pages", "quantity");
        newspapers.setColumns("author", "title", "field", "yearOfPublication", "pages", "quantity");
    }
    private void gridFormat(Grid<? extends Printed> grid, String name){
        grid.setSizeFull();
        grid.getColumns().forEach(column -> column.setAutoWidth(true));
        grid.setMinHeight("500px");
        add(new H3(name), grid);

    }
}
