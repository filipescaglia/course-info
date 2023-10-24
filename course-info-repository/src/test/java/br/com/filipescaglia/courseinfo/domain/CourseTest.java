package br.com.filipescaglia.courseinfo.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    @ParameterizedTest
    @CsvSource(textBlock = """
            , , 0, 
            Abc, , 0, 
            Abc, Name, 0,
            """)
    void filledShouldThrowExceptionWhenNotFilled(String id, String name, long length, String url) {
        assertThrows(IllegalArgumentException.class, () -> {
            new Course(id, name, length, url);
        });
    }

    @Test
    void filledShouldNotThrowExceptionWhenValuesAreFilled() {
        assertDoesNotThrow(() -> {
            new Course("id", "name", 0, "url");
        });
    }

}