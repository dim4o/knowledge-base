package kb.design_patterns.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CommaInputStream extends FilterInputStream {

    public CommaInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        if (Character.isWhitespace(c))
            return ',';

        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

}
