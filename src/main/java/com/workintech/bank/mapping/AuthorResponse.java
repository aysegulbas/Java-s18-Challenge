package com.workintech.bank.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {
    private int id;
    private String first_name;
    private String last_name;
    private List<BookResponse>bookResponses;//bir yazarın birden fazla kitabı olabilir,kitap bilgilerini book'tan okuma seni loopa sokuyor, bookresponse'dan oku
}
