package org.example.util;

public class DefaultMessageCreator implements MessageCreator{
    @Override
    public String getMessage(ComparisonResult result) {

        return """
                Здравствуйте, дорогая и.о. секретаря
                
                За последние сутки во вверенных Вам сайтах произошли следующие изменения:
                
                Исчезли следующие страницы:
                """ + String.join("\n", result.disappearedPages()) +
                """
                        
                        Появились следующие новые страницы:
                        """ +
                String.join("\n", result.newPages()) +
                """
                        Изменились следующие страницы:
                        """ +
                String.join("\n", result.updatedPages()) +
                """
                        
                        С уважением,
                        автоматизированная система
                        мониторинга.
                        """;
    }
}
