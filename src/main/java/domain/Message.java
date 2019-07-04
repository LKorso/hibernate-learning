package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

    private Long id;
    private String text;
    private Message nextMessage;

    public Message(String text) {
        this.text = text;
    }

}
