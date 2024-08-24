package com.sahapwnz.tennisscoreapp.util;

import com.sahapwnz.tennisscoreapp.entity.Match;
import com.sahapwnz.tennisscoreapp.entity.Player;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.internal.UserTypeSqlTypeAdapter;

public class HibernateUtil {
    @Getter
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = getConfiguration()
                .buildSessionFactory();
        ;
    }

    private static Configuration getConfiguration() {
        return new Configuration()
                .addAnnotatedClass(Player.class)
                .addAnnotatedClass(Match.class)
                .configure();
    }
}
