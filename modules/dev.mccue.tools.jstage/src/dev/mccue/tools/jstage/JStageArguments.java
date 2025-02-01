package dev.mccue.tools.jstage;

import dev.mccue.tools.ToolArguments;

import java.util.Collection;
import java.util.List;

public final class JStageArguments extends ToolArguments {
    static String toArgumentString(Object o) {
        return o == null ? "" : o.toString();
    }

    public JStageArguments() {
        super();
    }

    public JStageArguments(Collection<? extends String> c) {
        super(c);
    }

    @Override
    public JStageArguments argument(Object value) {
        super.argument(value);
        return this;
    }

    @Override
    public JStageArguments arguments(Object... values) {
        super.arguments(values);
        return this;
    }

    @Override
    public JStageArguments arguments(List<?> values) {
        super.arguments(values);
        return this;
    }

    @Override
    public JStageArguments separatedArgument(Object separator, Object... values) {
        super.separatedArgument(separator, values);
        return this;
    }

    @Override
    public JStageArguments separatedArgument(Object separator, List<?> values) {
        super.separatedArgument(separator, values);
        return this;
    }

    public JStageArguments __artifact(Object path) {
        add("--artifact");
        add(toArgumentString(path));
        return this;
    }

    public JStageArguments __classifier(Object path) {
        add("--classifier");
        add(toArgumentString(path));
        return this;
    }

    public JStageArguments __output(Object path) {
        add("--output");
        add(toArgumentString(path));
        return this;
    }

    public JStageArguments __type(Object path) {
        add("--type");
        add(toArgumentString(path));
        return this;
    }

    public JStageArguments __pom(Object pom) {
        add("--pom");
        add(toArgumentString(pom));
        return this;
    }


    public JStageArguments _V() {
        add("-V");
        return this;
    }

    public JStageArguments __version() {
        add("--version");
        return this;
    }

    public JStageArguments _h() {
        add("-h");
        return this;
    }

    public JStageArguments __help() {
        add("--help");
        return this;
    }

    public JStageArguments argumentFile(Object filename) {
        add("@" + toArgumentString(filename));
        return this;
    }
}
