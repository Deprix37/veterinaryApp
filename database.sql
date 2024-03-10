PGDMP                       |            VetApp    16.1    16.1 '    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    34091    VetApp    DATABASE     �   CREATE DATABASE "VetApp" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_United States.1252';
    DROP DATABASE "VetApp";
                postgres    false            �            1259    34092    animals    TABLE     6  CREATE TABLE public.animals (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    breed character varying(255) NOT NULL,
    color character varying(255) NOT NULL,
    date_of_birth date NOT NULL,
    gender character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    species character varying(255) NOT NULL,
    customer_id bigint,
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    34124    animals_seq    SEQUENCE     u   CREATE SEQUENCE public.animals_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.animals_seq;
       public          postgres    false            �            1259    34100    appointments    TABLE       CREATE TABLE public.appointments (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    appointment_date timestamp(6) without time zone NOT NULL,
    animal_id bigint,
    doctor_id bigint
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    34125    appointments_seq    SEQUENCE     z   CREATE SEQUENCE public.appointments_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.appointments_seq;
       public          postgres    false            �            1259    34105    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    available_date date NOT NULL,
    doctor_id bigint NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    34126    available_dates_seq    SEQUENCE     }   CREATE SEQUENCE public.available_dates_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.available_dates_seq;
       public          postgres    false            �            1259    34110 	   customers    TABLE     n  CREATE TABLE public.customers (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    34127    customers_seq    SEQUENCE     w   CREATE SEQUENCE public.customers_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.customers_seq;
       public          postgres    false            �            1259    34117    doctors    TABLE     l  CREATE TABLE public.doctors (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    address character varying(255) NOT NULL,
    city character varying(255) NOT NULL,
    mail character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    phone character varying(255) NOT NULL
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    34128    doctors_seq    SEQUENCE     u   CREATE SEQUENCE public.doctors_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.doctors_seq;
       public          postgres    false            �            1259    34149    vaccines    TABLE     T  CREATE TABLE public.vaccines (
    id bigint NOT NULL,
    created_at timestamp(6) without time zone,
    created_by timestamp(6) without time zone,
    code character varying(255) NOT NULL,
    name character varying(255) NOT NULL,
    protection_finish_date date NOT NULL,
    protection_start_date date NOT NULL,
    animal_id bigint
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    34156    vaccines_seq    SEQUENCE     v   CREATE SEQUENCE public.vaccines_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.vaccines_seq;
       public          postgres    false            �          0    34092    animals 
   TABLE DATA           ~   COPY public.animals (id, created_at, created_by, breed, color, date_of_birth, gender, name, species, customer_id) FROM stdin;
    public          postgres    false    215   o0       �          0    34100    appointments 
   TABLE DATA           j   COPY public.appointments (id, created_at, created_by, appointment_date, animal_id, doctor_id) FROM stdin;
    public          postgres    false    216   1       �          0    34105    available_dates 
   TABLE DATA           `   COPY public.available_dates (id, created_at, created_by, available_date, doctor_id) FROM stdin;
    public          postgres    false    217   v1       �          0    34110 	   customers 
   TABLE DATA           a   COPY public.customers (id, created_at, created_by, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    218   �1       �          0    34117    doctors 
   TABLE DATA           _   COPY public.doctors (id, created_at, created_by, address, city, mail, name, phone) FROM stdin;
    public          postgres    false    219   A2       �          0    34149    vaccines 
   TABLE DATA           �   COPY public.vaccines (id, created_at, created_by, code, name, protection_finish_date, protection_start_date, animal_id) FROM stdin;
    public          postgres    false    225   �2       �           0    0    animals_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.animals_seq', 101, true);
          public          postgres    false    220            �           0    0    appointments_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.appointments_seq', 51, true);
          public          postgres    false    221            �           0    0    available_dates_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.available_dates_seq', 101, true);
          public          postgres    false    222            �           0    0    customers_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.customers_seq', 51, true);
          public          postgres    false    223            �           0    0    doctors_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.doctors_seq', 51, true);
          public          postgres    false    224            �           0    0    vaccines_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.vaccines_seq', 1, false);
          public          postgres    false    226            5           2606    34099    animals animals_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    215            7           2606    34104    appointments appointments_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    216            9           2606    34109 $   available_dates available_dates_pkey 
   CONSTRAINT     b   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    217            ;           2606    34116    customers customers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    218            =           2606    34123    doctors doctors_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    219            ?           2606    34155    vaccines vaccines_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    225            A           2606    34134 (   appointments fk95vepu86o8syqtux9gkr71bhy    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk95vepu86o8syqtux9gkr71bhy FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk95vepu86o8syqtux9gkr71bhy;
       public          postgres    false    216    215    4661            @           2606    34129 #   animals fkb36lt3kj4mrbdx5btxmp4j60n    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n FOREIGN KEY (customer_id) REFERENCES public.customers(id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fkb36lt3kj4mrbdx5btxmp4j60n;
       public          postgres    false    215    4667    218            D           2606    34157 $   vaccines fkeasdy15b2kp5j4k13x2dfudqs    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs FOREIGN KEY (animal_id) REFERENCES public.animals(id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkeasdy15b2kp5j4k13x2dfudqs;
       public          postgres    false    4661    225    215            B           2606    34139 (   appointments fkmujeo4tymoo98cmf7uj3vsv76    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76 FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fkmujeo4tymoo98cmf7uj3vsv76;
       public          postgres    false    4669    219    216            C           2606    34144 +   available_dates fknb419ilm71d71rm584rk460pk    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fknb419ilm71d71rm584rk460pk FOREIGN KEY (doctor_id) REFERENCES public.doctors(id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fknb419ilm71d71rm584rk460pk;
       public          postgres    false    217    219    4669            �   �   x�}�A
�0EדSx���d�Igׅ;���@K--m��t!؊.��>��#.�/��0*�hEP8�C��߆��`���фcu�C?�,���j(�/KY8m>)�M��}��ܼc+XS4�VS����%�E���i�ky���o94'k�yA�C�      �   N   x��̱�@C��2\�ع�d���h�Nr�������v M�Db���q*k< �ۢWis�.Y�;�׼TDn��Q      �   A   x�3�4202�50�54P04�25�26�3��41&F��2BQhae``e`�gbddlA�А=... 8��      �   j   x�3�4202�50�54P04�26�21ֳ00776E�21�25�32����,H�K����,.I�K*�	-HI,I�L��M-)�2�Kr3s���s!�P5�0`d����� MV#F      �   P   x�3�4202�50�54P04�21�26�35�054�'U�X��_PTʙ����ș�X��ᐒZ�����q��r��qqq �U�      �      x������ � �     