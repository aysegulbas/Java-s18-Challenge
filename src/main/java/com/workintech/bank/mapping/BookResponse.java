package com.workintech.bank.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {// bu sınıfın amacı içiçe objelerden oluşan ve loopa giren durumu JsonIgnore'dan başka yolla çözmektir
    private int bookId;
    private String bookName;
    private String categoryName;
    private String authorFirstName;
    private String authorLastName;

    public String getCategoryName() {
        return categoryName;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public BookResponse(int bookId, String bookName, String categoryName) {//yukardaki firstname ve lastnamei sonradan ekledik, aşağıdaki üçlü constructorı yazdıkki daha önce üçlü kullandıklarımız eksik diye hata vermesin
        this.bookId = bookId;
        this.bookName = bookName;
        this.categoryName = categoryName;
    }
}
