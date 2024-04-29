INSERT INTO `role` (`id`, `name`) VALUES (1, 'USER');
INSERT INTO `role` (`id`, `name`) VALUES (2, 'ADMIN');

INSERT INTO `user_entity` (`id`, `address`, `city`, `email`, `first_name`, `last_name`, `password`, `phone_number`, `postal_code`) VALUES (1, '123 rue test', 'Paris', 'john@doe.fr', 'John', 'Doe', '$2a$10$kbw9zL.kpnCkEowkWARwtuO4O8uk6gXysBq8.1yAIqE1N/pSatF5i', '0612345678', '75013');

INSERT INTO `user_entity_roles` (`roles_id`, `user_entity_id`) VALUES (1, 1);
INSERT INTO `user_entity_roles` (`roles_id`, `user_entity_id`) VALUES (2, 1);

INSERT INTO `category` (`id`, `name`) VALUES (1, 'Cafards - Blattes');
INSERT INTO `category` (`id`, `name`) VALUES (2, 'Rats - Souris');
INSERT INTO `category` (`id`, `name`) VALUES (3, 'Nid de Frelons - Guêpes');
INSERT INTO `category` (`id`, `name`) VALUES (4, 'Punaises de lit');
INSERT INTO `category` (`id`, `name`) VALUES (5, 'Autres rampants');
INSERT INTO `category` (`id`, `name`) VALUES (6, 'Autres volants');

INSERT INTO `service_proposition` (`id`,`name`, `description`, `price`, `picture`) VALUES (1, 'Cafards - Blattes', 'Le cafard est un insecte très résistant. Il se faufile dans la salle de bain et la cuisine, deux points stratégiques de votre logement. Pour les faire partir durablement, contactez nous par téléphone ou demandez votre devis en ligne.', 69, 'cafardIcone.png');
INSERT INTO `service_proposition` (`id`,`name`, `description`, `price`, `picture`) VALUES (2, 'Rats - Souris', 'Notre société de dératisation, désinsectisation et désinfection est votre partenaire de choix pour régler tous vos problèmes de rongeurs. Alors n''attendez pas et contactez nous par téléphone ou demandez votre devis en ligne', 129, 'ratIcone.png');
INSERT INTO `service_proposition` (`id`,`name`, `description`, `price`, `picture`) VALUES (3, 'Nid de Frelons - Guêpes', 'Éliminez les nids de frelons avec notre service de désinsectisation expert. Rapidité, sécurité et efficacité garanties. Protégez votre environnement dès maintenant !', 149, 'frelonIcone.png');
INSERT INTO `service_proposition` (`id`,`name`, `description`, `price`, `picture`) VALUES (4, 'Punaises de lit', 'Nous offrons un service spécialisé pour éradiquer les punaises de lit. Faites confiance à notre expertise pour vous débarrasser de ces parasites. Rapide, sûr et efficace, protégez-vous et retrouvez la tranquillité chez vous dès maintenant !', 169, 'punaiseIcone.png');


INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 29.99, 1, 'PestControlX', 'Spray insecticide pour éliminer les cafards et les blattes.', 'Spray Insecticide Anti-Cafards', 'spray_anti_cafards.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 19.99, 2, 'RodentMaster', 'Piège à souris efficace pour attraper les rongeurs sans produits chimiques.', 'Piège à Souris Ultra', 'piege_a_souris.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 39.99, 3, 'BugAway', 'Répulsif puissant contre les moustiques, idéal pour une utilisation en extérieur.', 'Répulsif Moustiques Outdoor', 'repulsif_moustiques.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 49.99, 4, 'RatStopper', 'Appât empoisonné pour éliminer les rats et les souris de manière efficace.', 'Appât Anti-Rats et Souris', 'appat_anti_rats.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 14.99, 5, 'InsectShield', 'Ruban adhésif non toxique pour capturer les mouches et les moustiques.', 'Ruban Adhésif Anti-Insectes', 'ruban_anti_mouches.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 24.99, 6, 'PestBeGone', 'Granulés répulsifs pour éloigner les fourmis et les araignées de votre maison.', 'Granulés Répulsifs Anti-Fourmis', 'granules_anti_fourmis.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 34.99, 7, 'MouseGuard', 'Répulsif à ultrasons pour chasser les souris et les rats sans produits chimiques.', 'Répulsif à Ultrasons Anti-Rongeurs', 'repulsif_ultrasons.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 9.99, 8, 'BugBlocker', 'Aérosol écologique pour repousser les moustiques et les mouches de manière naturelle.', 'Aérosol Anti-Insectes Bio', 'aerosol_bio_moustiques.jpg');
INSERT INTO `product` (`available`, `price`, `id`, `brand`, `description`, `name`, `picture`) VALUES (1, 59.99, 9, 'RoachRaid', 'Piège à cafards et à blattes avec appât intégré pour une élimination rapide.', 'Piège Anti-Cafards avec Appât', 'piege_anti_cafards.jpg');

INSERT INTO `product_category` (`product_id`, `category_id`) VALUES (1, 1);
INSERT INTO `product_category` (`product_id`, `category_id`) VALUES (1, 2);

INSERT INTO `quote_request` (`approximated_price`, `piece_number`, `reception_date`, `starting_date`, `total_area`, `category_id`, `id`, `user_id`, `description`, `picture1`, `picture2`, `picture3`) VALUES (125, 2, '2024-04-23', '2024-04-10', 28.5, 2, 1, 1, 'Description test de ma demande de devis', 'phototest.png', 'phototest2.png', NULL);