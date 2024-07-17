package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

public class HibernateUtil {
    private static Configuration getConfiguration() {
        return new Configuration()
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(Match.class)
                .setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy())
                .configure();
    }

    public static SessionFactory getSessionFactory() {
        return getConfiguration()
                .buildSessionFactory();
    }
}
