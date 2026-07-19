package dev.mccue.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/// The arguments to pass to a tool.
public abstract class ToolArguments extends ArrayList<String> {
    public ToolArguments() {
        super();
    }

    public ToolArguments(Collection<? extends String> c) {
        super(c);
    }

    /// Either returns the toString of the given object or an empty string if null.
    ///
    /// This is intended to help with escaping of arguments. A `null` in the context
    /// of CLI args is unideal, but if you get one you probably want to either
    /// skip it entirely or put in an empty string so at least what you pass is valid.
    ///
    /// The approach preferred by this library is the second one. The first can be
    /// done for specific tool arguments at the author's discretion.
    ///
    /// @return o.toString() or "" if null.
    protected static String toArgumentString(Object o) {
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
