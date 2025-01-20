package dev.mccue.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ToolArguments extends ArrayList<String> {
    public ToolArguments() {
        super();
    }

    public ToolArguments(Collection<? extends String> c) {
        super(c);
    }

    static String toArgumentString(Object o) {
        return o == null ? "" : o.toString();
    }

    public ToolArguments argument(Object value) {
        this.add(toArgumentString(value));
        return this;
    }

    public ToolArguments arguments(Object... values) {
        for (var value : values) {
            this.add(toArgumentString(value));
        }
        return this;
    }

    public ToolArguments arguments(List<?> values) {
        for (var value : values) {
            this.add(toArgumentString(value));
        }
        return this;
    }

    public ToolArguments separatedArgument(Object separator, Object... values) {
        return separatedArgument(separator, Arrays.asList(values));
    }

    public ToolArguments separatedArgument(Object separator, List<?> values) {
        this.add(
                values.stream()
                        .map(ToolArguments::toArgumentString)
                        .collect(Collectors.joining(toArgumentString(separator)))
        );
        return this;
    }
}
