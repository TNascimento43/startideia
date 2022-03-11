package com.example.startaideia.configuration;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import java.util.Locale;

public class CustomPhysicalNamingStrategyImpl implements PhysicalNamingStrategy {

    private static boolean isUnderscoreRequired(char before, char current, char after) {
        return Character.isUpperCase(before) && Character.isUpperCase(current) && Character.isUpperCase(after);
    }

    public Identifier toPhysicalCatalogName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return this.apply(name);
    }

    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return this.getIdentifier(name.getText(), name.isQuoted());
    }

    public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return this.apply(name);
    }

    public Identifier toPhysicalSequenceName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return this.apply(name);
    }

    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return this.apply(name);
    }

    private Identifier apply(Identifier name) {
        if (name == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder(name.getText().replace('.', '_'));
        for (int i = 1; i < builder.length() - 1; ++i) {
            if (isUnderscoreRequired(builder.charAt(i - 1), builder.charAt(i), builder.charAt(i + 1))) {
                builder.insert(i++, '_');
            }
        }
        return this.getIdentifier(builder.toString(), name.isQuoted());
    }

    private Identifier getIdentifier(String name, boolean quoted) {
        name = name.toLowerCase(Locale.ROOT);
        return new Identifier(name, quoted);
    }
}

