package com.example.biblior.entities;

public class PrintedBuilder {
    private String printedAuthor;
    private String printedTitle;
    private PrintedType printedType;
    private int printedFeePrice;
    private int printedPages;
    private int printedYearOfPublication;
    private String articleField;
    private Genre bookGenre;
    private String newspaperCountry;

    public Printed build(){
        if(this.printedType ==PrintedType.Book){
            if(this.bookGenre!=null && this.printedAuthor!=null && this.printedTitle!=null){
                return new Book(this.printedTitle, this.printedAuthor, this.printedYearOfPublication, this.printedPages, this.printedFeePrice, this.bookGenre.enumFormat());
            }else{
                throw new IllegalArgumentException("Book genre, author, or title may not be inputted. Recheck the input.");
            }
        }else if(this.printedType ==PrintedType.Article){
            if(this.articleField!=null && this.printedAuthor!=null && this.printedTitle!=null){
                return new Article(this.printedTitle, this.printedAuthor, this.printedYearOfPublication, this.printedPages, this.printedFeePrice, this.articleField);
            }else{
                throw new IllegalArgumentException("Article field, author, or title may not be inputted. Recheck the input.");
            }
        }else if(this.printedType ==PrintedType.Newspaper){
            if(this.newspaperCountry!=null && this.printedAuthor!=null && this.printedTitle!=null){
                return new Article(this.printedTitle, this.printedAuthor, this.printedYearOfPublication, this.printedPages, this.printedFeePrice, this.newspaperCountry);
            }else{
                throw new IllegalArgumentException("The country of origin, author, or title may not be inputted. Recheck the input.");
            }
        }else{
            throw new IllegalArgumentException("Select the right printed type.");
        }
    }

    public PrintedBuilder author(String printedAuthor){
        this.printedAuthor = printedAuthor;
        return this;
    }
    public PrintedBuilder title(String printedTitle){
        this.printedTitle = printedTitle;
        return this;
    }
    public PrintedBuilder type(PrintedType pritnedType){
        this.printedType = pritnedType;
        return this;
    }
    public PrintedBuilder feePrice(int printedFeePrice){
        this.printedFeePrice = printedFeePrice;
        return this;
    }
    public PrintedBuilder pages(int printedPages){
        this.printedPages = printedPages;
        return this;
    }
    public PrintedBuilder yearOfPublication(int PrintedYearOfPublication){
        this.printedYearOfPublication = PrintedYearOfPublication;
        return this;
    }
    public PrintedBuilder articleField(String articleField){
        this.articleField = articleField;
        return this;
    }
    public PrintedBuilder bookGenre(Genre bookGenre){
        this.bookGenre = bookGenre;
        return this;
    }
    public PrintedBuilder newspaperCountry(String newspaperCountry){
        this.newspaperCountry = newspaperCountry;
        return this;
    }


    private void setPrintedAuthor(String printedAuthor) {
        this.printedAuthor = printedAuthor;
    }

    private void setPrintedTitle(String printedTitle) {
        this.printedTitle = printedTitle;
    }

    private void setPrintedType(PrintedType printedType) {
        this.printedType = printedType;
    }

    private void setPrintedFeePrice(int printedFeePrice) {
        this.printedFeePrice = printedFeePrice;
    }

    private void setPrintedPages(int printedPages) {
        this.printedPages = printedPages;
    }

    private void setPrintedYearOfPublication(int printedYearOfPublication) {
        this.printedYearOfPublication = printedYearOfPublication;
    }

    private void setArticleField(String articleField) {
        this.articleField = articleField;
    }

    private void setBookGenre(Genre bookGenre) {
        this.bookGenre = bookGenre;
    }

    private void setNewspaperCountry(String newspaperCountry) {
        this.newspaperCountry = newspaperCountry;
    }
}
