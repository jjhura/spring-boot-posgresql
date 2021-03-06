PGDMP                         x            postgres_demo    12.1    12.1 &    +           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ,           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            -           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            .           1262    45398    postgres_demo    DATABASE     �   CREATE DATABASE postgres_demo WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE postgres_demo;
                postgres    false            �            1259    45409    config_point    TABLE     �   CREATE TABLE public.config_point (
    id bigint NOT NULL,
    config double precision,
    config_old double precision,
    create_on timestamp without time zone
);
     DROP TABLE public.config_point;
       public         heap    postgres    false            �            1259    45407    config_point_id_seq    SEQUENCE     |   CREATE SEQUENCE public.config_point_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.config_point_id_seq;
       public          postgres    false    203            /           0    0    config_point_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.config_point_id_seq OWNED BY public.config_point.id;
          public          postgres    false    202            �            1259    45417    loyalty_card    TABLE     �  CREATE TABLE public.loyalty_card (
    id bigint NOT NULL,
    code character varying(20),
    create_on timestamp without time zone,
    end_date timestamp without time zone,
    modified_on timestamp without time zone,
    phone character varying(20),
    point double precision,
    start_date timestamp without time zone,
    total_spent double precision,
    loyalty_card_type_id bigint
);
     DROP TABLE public.loyalty_card;
       public         heap    postgres    false            �            1259    45415    loyalty_card_id_seq    SEQUENCE     |   CREATE SEQUENCE public.loyalty_card_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.loyalty_card_id_seq;
       public          postgres    false    205            0           0    0    loyalty_card_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.loyalty_card_id_seq OWNED BY public.loyalty_card.id;
          public          postgres    false    204            �            1259    45425    loyalty_card_type    TABLE     '  CREATE TABLE public.loyalty_card_type (
    id bigint NOT NULL,
    create_on timestamp without time zone,
    discount_percent double precision,
    duration double precision,
    modified_on timestamp without time zone,
    name character varying(255),
    spent_threshold double precision
);
 %   DROP TABLE public.loyalty_card_type;
       public         heap    postgres    false            �            1259    45423    loyalty_card_type_id_seq    SEQUENCE     �   CREATE SEQUENCE public.loyalty_card_type_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.loyalty_card_type_id_seq;
       public          postgres    false    207            1           0    0    loyalty_card_type_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.loyalty_card_type_id_seq OWNED BY public.loyalty_card_type.id;
          public          postgres    false    206            �            1259    45433    transaction    TABLE     �   CREATE TABLE public.transaction (
    id bigint NOT NULL,
    create_on timestamp without time zone,
    point_adjust double precision,
    spent_adjust double precision,
    loyalty_card_id bigint
);
    DROP TABLE public.transaction;
       public         heap    postgres    false            �            1259    45431    transaction_id_seq    SEQUENCE     {   CREATE SEQUENCE public.transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.transaction_id_seq;
       public          postgres    false    209            2           0    0    transaction_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.transaction_id_seq OWNED BY public.transaction.id;
          public          postgres    false    208            �
           2604    45412    config_point id    DEFAULT     r   ALTER TABLE ONLY public.config_point ALTER COLUMN id SET DEFAULT nextval('public.config_point_id_seq'::regclass);
 >   ALTER TABLE public.config_point ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            �
           2604    45420    loyalty_card id    DEFAULT     r   ALTER TABLE ONLY public.loyalty_card ALTER COLUMN id SET DEFAULT nextval('public.loyalty_card_id_seq'::regclass);
 >   ALTER TABLE public.loyalty_card ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    205    204    205            �
           2604    45428    loyalty_card_type id    DEFAULT     |   ALTER TABLE ONLY public.loyalty_card_type ALTER COLUMN id SET DEFAULT nextval('public.loyalty_card_type_id_seq'::regclass);
 C   ALTER TABLE public.loyalty_card_type ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    207    207            �
           2604    45436    transaction id    DEFAULT     p   ALTER TABLE ONLY public.transaction ALTER COLUMN id SET DEFAULT nextval('public.transaction_id_seq'::regclass);
 =   ALTER TABLE public.transaction ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            "          0    45409    config_point 
   TABLE DATA           I   COPY public.config_point (id, config, config_old, create_on) FROM stdin;
    public          postgres    false    203   5,       $          0    45417    loyalty_card 
   TABLE DATA           �   COPY public.loyalty_card (id, code, create_on, end_date, modified_on, phone, point, start_date, total_spent, loyalty_card_type_id) FROM stdin;
    public          postgres    false    205   u,       &          0    45425    loyalty_card_type 
   TABLE DATA           z   COPY public.loyalty_card_type (id, create_on, discount_percent, duration, modified_on, name, spent_threshold) FROM stdin;
    public          postgres    false    207   �,       (          0    45433    transaction 
   TABLE DATA           a   COPY public.transaction (id, create_on, point_adjust, spent_adjust, loyalty_card_id) FROM stdin;
    public          postgres    false    209   t-       3           0    0    config_point_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.config_point_id_seq', 1, true);
          public          postgres    false    202            4           0    0    loyalty_card_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.loyalty_card_id_seq', 1, true);
          public          postgres    false    204            5           0    0    loyalty_card_type_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.loyalty_card_type_id_seq', 6, true);
          public          postgres    false    206            6           0    0    transaction_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.transaction_id_seq', 5, true);
          public          postgres    false    208            �
           2606    45414    config_point config_point_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.config_point
    ADD CONSTRAINT config_point_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.config_point DROP CONSTRAINT config_point_pkey;
       public            postgres    false    203            �
           2606    45422    loyalty_card loyalty_card_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.loyalty_card
    ADD CONSTRAINT loyalty_card_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.loyalty_card DROP CONSTRAINT loyalty_card_pkey;
       public            postgres    false    205            �
           2606    45430 (   loyalty_card_type loyalty_card_type_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.loyalty_card_type
    ADD CONSTRAINT loyalty_card_type_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.loyalty_card_type DROP CONSTRAINT loyalty_card_type_pkey;
       public            postgres    false    207            �
           2606    45438    transaction transaction_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_pkey;
       public            postgres    false    209            �
           1259    45439    idx_config_point    INDEX     G   CREATE INDEX idx_config_point ON public.config_point USING btree (id);
 $   DROP INDEX public.idx_config_point;
       public            postgres    false    203            �
           1259    45440    idx_loyalty_card    INDEX     G   CREATE INDEX idx_loyalty_card ON public.loyalty_card USING btree (id);
 $   DROP INDEX public.idx_loyalty_card;
       public            postgres    false    205            �
           1259    45441    idx_loyalty_card_type    INDEX     Q   CREATE INDEX idx_loyalty_card_type ON public.loyalty_card_type USING btree (id);
 )   DROP INDEX public.idx_loyalty_card_type;
       public            postgres    false    207            �
           1259    45442    idx_transaction    INDEX     E   CREATE INDEX idx_transaction ON public.transaction USING btree (id);
 #   DROP INDEX public.idx_transaction;
       public            postgres    false    209            �
           2606    45443 (   loyalty_card fk2i7c5klodx26ystqarvr1o0vs    FK CONSTRAINT     �   ALTER TABLE ONLY public.loyalty_card
    ADD CONSTRAINT fk2i7c5klodx26ystqarvr1o0vs FOREIGN KEY (loyalty_card_type_id) REFERENCES public.loyalty_card_type(id);
 R   ALTER TABLE ONLY public.loyalty_card DROP CONSTRAINT fk2i7c5klodx26ystqarvr1o0vs;
       public          postgres    false    205    2717    207            �
           2606    45448 '   transaction fk30e5opjjruxqxkxol9v2b6s8t    FK CONSTRAINT     �   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT fk30e5opjjruxqxkxol9v2b6s8t FOREIGN KEY (loyalty_card_id) REFERENCES public.loyalty_card(id);
 Q   ALTER TABLE ONLY public.transaction DROP CONSTRAINT fk30e5opjjruxqxkxol9v2b6s8t;
       public          postgres    false    2714    209    205            "   0   x�3�440 aN##]]#C+#C+#=cSCKK�=... ��h      $   T   x�}���0�jg
H�ߎ�()��⠠�T��� (
EE���dL���a�ւ����@�#WqЬ��zX�5 Z�VJ9���      &   �   x�u�K�0D��)z� �$�8K7Q��H�T@9";��y3�X@HȐ5b<�L�A���l1�]��
���S�L�۪��t��{ȿt�w�253��Sɵ !kT79�3�\j.k�uM���Ķ����zɳC�?��Oc      (   `   x�m��	� ��g3E0\b��Y��� ��?~�IR(2,�]cf�=D�&�HBz0�(ƭ�uO���#<bSv* +Pm��/��UBcM-���D� o�#�     