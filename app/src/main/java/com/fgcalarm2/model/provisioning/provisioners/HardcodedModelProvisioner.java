package com.fgcalarm2.model.provisioning.provisioners;

import com.fgcalarm2.model.entities.Line;
import com.fgcalarm2.model.entities.Station;
import com.fgcalarm2.model.entities.types.Location;
import com.fgcalarm2.model.provisioning.ModelProvisioner;

import java.util.ArrayList;

/**
 * Created by Biel on 26/11/2016.
 */

public class HardcodedModelProvisioner extends ModelProvisioner {
    @Override
    public void provision() {
        //METROPOLITAN Lines
        Line l6 = lineRepository.save(new Line(null, "L6",7));
        Line l7 = lineRepository.save(new Line(null, "L7",8));
        Line l8 = lineRepository.save(new Line(null, "L8",9));
        Line l12 = lineRepository.save(new Line(null, "L12",10));

        //BARCELONA-VALLES Lines
        Line s1 = lineRepository.save(new Line(null, "S1",0));
        Line s2 = lineRepository.save(new Line(null, "S2",1));
        Line s5 = lineRepository.save(new Line(null, "S5",2));
        Line s55 = lineRepository.save(new Line(null, "S55",3));

        //LLOBREGAT-ANOIA Lines
        Line s33 = lineRepository.save(new Line(null, "S33",4));
        Line s4 = lineRepository.save(new Line(null, "S4",5));
        Line s8 = lineRepository.save(new Line(null, "S8",6));
        Line r5 = lineRepository.save(new Line(null, "R5",11));
        Line r50 = lineRepository.save(new Line(null, "R50",12));
        Line r6 = lineRepository.save(new Line(null, "R6",13));
        Line r60 = lineRepository.save(new Line(null, "R60",14));

        //REGIONAL SERVICES
        Line ca7 = lineRepository.save(new Line(null, "Ca7",15));

        //Stations
        ArrayList<Line> linesarbrera = new ArrayList<>();
        linesarbrera.add(s4);
        linesarbrera.add(r5);
        Station arbrera = stationRepository.save(new Station(null, "Arbrera", new Location(41.522567, 1.9067), linesarbrera));

        ArrayList<Line> linesager = new ArrayList<>();
        linesager.add(ca7);
        Station ager = stationRepository.save(new Station(null, "Àger", new Location(42.006714, 0.851506), linesager));

        ArrayList<Line> linesaeridemontserrat = new ArrayList<>();
        linesaeridemontserrat.add(r5);
        Station aeridemontserrat = stationRepository.save(new Station(null, "Aeri de Montserrat", new Location(41.590875, 1.853181), linesaeridemontserrat));

        ArrayList<Line> linesalcoletge = new ArrayList<>();
        linesalcoletge.add(ca7);
        Station alcoletge = stationRepository.save(new Station(null, "Alcoletge", new Location(41.654386, 0.685833), linesalcoletge));

        ArrayList<Line> linesalmeda = new ArrayList<>();
        linesalmeda.add(l8);
        linesalmeda.add(s33);
        linesalmeda.add(s4);
        linesalmeda.add(s8);
        linesalmeda.add(r5);
        linesalmeda.add(r6);
        linesalmeda.add(r50);
        linesalmeda.add(r60);
        Station almeda = stationRepository.save(new Station(null, "Almeda", new Location(41.353153, 2.085653), linesalmeda));

        ArrayList<Line> linesavtibidabo = new ArrayList<>();
        linesavtibidabo.add(l7);
        Station avtibidabo = stationRepository.save(new Station(null, "Avinguda Tibidabo", new Location(41.409986, 2.137119), linesavtibidabo));

        ArrayList<Line> linesbaixadordevallvidrera = new ArrayList<>();
        linesbaixadordevallvidrera.add(s1);
        linesbaixadordevallvidrera.add(s2);
        Station baixadordevallvidrera = stationRepository.save(new Station(null, "Baixador de Vallvidrera", new Location(41.419786, 2.097289), linesbaixadordevallvidrera));

        ArrayList<Line> linesbalaguer = new ArrayList<>();
        linesbalaguer.add(ca7);
        Station balaguer = stationRepository.save(new Station(null, "Balaguer", new Location(41.789397, 0.8148), linesbalaguer));

        ArrayList<Line> lineslabeguda = new ArrayList<>();
        lineslabeguda.add(r6);
        Station labeguda = stationRepository.save(new Station(null, "La Beguda", new Location(41.501744, 1.838789), lineslabeguda));

        ArrayList<Line> linesbellaterra = new ArrayList<>();
        linesbellaterra.add(s2);
        linesbellaterra.add(s55);
        Station bellaterra = stationRepository.save(new Station(null, "Bellaterra", new Location(41.500928, 2.090467), linesbellaterra));

        ArrayList<Line> lineslabonanova = new ArrayList<>();
        lineslabonanova.add(l6);
        lineslabonanova.add(s5);
        lineslabonanova.add(s55);
        Station labonanova = stationRepository.save(new Station(null, "La Bonanova", new Location(41.397861, 2.135756), lineslabonanova));

        ArrayList<Line> linescanparellada = new ArrayList<>();
        linescanparellada.add(r6);
        Station canparellada = stationRepository.save(new Station(null, "Can Parellada", new Location(41.502203, 1.830808), linescanparellada));

        ArrayList<Line> linescanros = new ArrayList<>();
        linescanros.add(s33);
        linescanros.add(s4);
        linescanros.add(s8);
        linescanros.add(r5);
        linescanros.add(r6);
        Station canros = stationRepository.save(new Station(null, "Can Ros", new Location(41.399325, 2.004964), linescanros));

        ArrayList<Line> linescapellades = new ArrayList<>();
        linescapellades.add(r6);
        linescapellades.add(r60);
        Station capellades = stationRepository.save(new Station(null, "Capellades", new Location(41.521506, 1.695117), linescapellades));

        ArrayList<Line> linescastellbellielvilar = new ArrayList<>();
        linescastellbellielvilar.add(r5);
        Station castellbellielvilar = stationRepository.save(new Station(null, "Castellbell i el Vilar", new Location(41.640503, 1.854814), linescastellbellielvilar));

        ArrayList<Line> linescellersllimiana = new ArrayList<>();
        linescellersllimiana.add(ca7);
        Station cellersllimiana = stationRepository.save(new Station(null, "Cellers-Llimiana", new Location(42.058669, 0.882939), linescellersllimiana));

        ArrayList<Line> linescoloniaguell = new ArrayList<>();
        linescoloniaguell.add(s33);
        linescoloniaguell.add(s4);
        linescoloniaguell.add(s8);
        Station coloniaguell = stationRepository.save(new Station(null, "Colònia Güell", new Location(41.364433, 2.031303), linescoloniaguell));

        ArrayList<Line> linescornellariera = new ArrayList<>();
        linescornellariera.add(l8);
        linescornellariera.add(s33);
        linescornellariera.add(s4);
        linescornellariera.add(s8);
        linescornellariera.add(r5);
        linescornellariera.add(r6);
        linescornellariera.add(r50);
        linescornellariera.add(r60);
        Station cornellariera = stationRepository.save(new Station(null, "Cornellà-Riera", new Location(41.351525, 2.070756), linescornellariera));

        ArrayList<Line> lineseuropafira = new ArrayList<>();
        lineseuropafira.add(l8);
        lineseuropafira.add(s33);
        lineseuropafira.add(s4);
        lineseuropafira.add(s8);
        lineseuropafira.add(r5);
        lineseuropafira.add(r6);
        lineseuropafira.add(r50);
        lineseuropafira.add(r60);
        Station europafira = stationRepository.save(new Station(null, "Europa | Fira", new Location(41.356978, 2.124908), lineseuropafira));

        ArrayList<Line> lineslafloresta = new ArrayList<>();
        lineslafloresta.add(s1);
        lineslafloresta.add(s2);
        lineslafloresta.add(s5);
        lineslafloresta.add(s55);
        Station lafloresta = stationRepository.save(new Station(null, "La Floresta", new Location(41.444608, 2.073069), lineslafloresta));

        ArrayList<Line> lineslesfonts = new ArrayList<>();
        lineslesfonts.add(s1);
        Station lesfonts = stationRepository.save(new Station(null, "Les Fonts", new Location(41.528447, 2.033458), lineslesfonts));

        ArrayList<Line> linesgerb = new ArrayList<>();
        linesgerb.add(ca7);
        Station gerb = stationRepository.save(new Station(null, "Gerb", new Location(41.824292, 0.812764), linesgerb));

        ArrayList<Line> linesgornal = new ArrayList<>();
        linesgornal.add(l8);
        linesgornal.add(s33);
        linesgornal.add(s4);
        linesgornal.add(s8);
        linesgornal.add(r5);
        linesgornal.add(r6);
        linesgornal.add(r50);
        linesgornal.add(r60);
        Station gornal = stationRepository.save(new Station(null, "Gornal", new Location(41.351089, 2.112014), linesgornal));

        ArrayList<Line> linesgracia = new ArrayList<>();
        linesgracia.add(l6);
        linesgracia.add(l7);
        linesgracia.add(s1);
        linesgracia.add(s2);
        linesgracia.add(s5);
        linesgracia.add(s55);
        Station gracia = stationRepository.save(new Station(null, "Gràcia", new Location(41.399556, 2.152167), linesgracia));

        ArrayList<Line> linesguardiadetremp = new ArrayList<>();
        linesguardiadetremp.add(ca7);
        Station guardiadetremp = stationRepository.save(new Station(null, "Guàrdia de Tremp", new Location(42.101402, 0.888164), linesguardiadetremp));

        ArrayList<Line> lineshospitalgeneral = new ArrayList<>();
        lineshospitalgeneral.add(s1);
        lineshospitalgeneral.add(s5);
        Station hospitalgeneral = stationRepository.save(new Station(null, "Hospital General", new Location(41.476147, 2.046519), lineshospitalgeneral));

        ArrayList<Line> lineshospitaletavcarrilet = new ArrayList<>();
        lineshospitaletavcarrilet.add(l8);
        lineshospitaletavcarrilet.add(s33);
        lineshospitaletavcarrilet.add(s4);
        lineshospitaletavcarrilet.add(s8);
        lineshospitaletavcarrilet.add(r5);
        lineshospitaletavcarrilet.add(r6);
        lineshospitaletavcarrilet.add(r50);
        lineshospitaletavcarrilet.add(r60);
        Station hospitaletavcarrilet = stationRepository.save(new Station(null, "Hospitalet - Av. Carrilet", new Location(41.357647, 2.102719), lineshospitaletavcarrilet));

        ArrayList<Line> linesigualada = new ArrayList<>();
        linesigualada.add(r6);
        linesigualada.add(r60);
        Station igualada = stationRepository.save(new Station(null, "Igualada", new Location(41.578001, 1.629981), linesigualada));

        ArrayList<Line> linesildefonscerda = new ArrayList<>();
        linesildefonscerda.add(l8);
        linesildefonscerda.add(s33);
        linesildefonscerda.add(s4);
        linesildefonscerda.add(s8);
        linesildefonscerda.add(r5);
        linesildefonscerda.add(r6);
        linesildefonscerda.add(r50);
        linesildefonscerda.add(r60);
        Station ildefonscerda = stationRepository.save(new Station(null, "Ildefons Cerdà", new Location(41.360986, 2.130831), linesildefonscerda));

        ArrayList<Line> linesmagorialacampana = new ArrayList<>();
        linesmagorialacampana.add(l8);
        linesmagorialacampana.add(s33);
        linesmagorialacampana.add(s4);
        linesmagorialacampana.add(s8);
        linesmagorialacampana.add(r5);
        linesmagorialacampana.add(r6);
        Station magorialacampana = stationRepository.save(new Station(null, "Magòria - la Campana", new Location(41.368017, 2.139589), linesmagorialacampana));

        ArrayList<Line> linesmanresaalta = new ArrayList<>();
        linesmanresaalta.add(r5);
        linesmanresaalta.add(r50);
        Station manresaalta = stationRepository.save(new Station(null, "Manresa - Alta", new Location(41.732081, 1.832972), linesmanresaalta));

        ArrayList<Line> linesmanresabaixador = new ArrayList<>();
        linesmanresabaixador.add(r5);
        linesmanresabaixador.add(r50);
        Station manresabaixador = stationRepository.save(new Station(null, "Manresa - Baixador", new Location(41.731414, 1.827897), linesmanresabaixador));

        ArrayList<Line> linesmanresaviladordis = new ArrayList<>();
        linesmanresaviladordis.add(r5);
        linesmanresaviladordis.add(r50);
        Station manresaviladordis = stationRepository.save(new Station(null, "Manresa - Viladordis", new Location(41.7247, 1.833986), linesmanresaviladordis));

        ArrayList<Line> linesmartorellcentral = new ArrayList<>();
        linesmartorellcentral.add(s4);
        linesmartorellcentral.add(s8);
        linesmartorellcentral.add(r5);
        linesmartorellcentral.add(r6);
        linesmanresaviladordis.add(r50);
        linesmanresaviladordis.add(r60);
        Station martorellcentral = stationRepository.save(new Station(null, "Martorell - Central", new Location(41.478944, 1.925422), linesmartorellcentral));

        ArrayList<Line> linesmartorellenllac = new ArrayList<>();
        linesmartorellenllac.add(s4);
        linesmartorellenllac.add(s8);
        linesmartorellenllac.add(r5);
        linesmartorellenllac.add(r6);
        Station martorellenllac = stationRepository.save(new Station(null, "Martorell - Enllaç", new Location(41.483833, 1.918972), linesmartorellenllac));

        ArrayList<Line> linesmartorellvilacastellbisbal = new ArrayList<>();
        linesmartorellvilacastellbisbal.add(s4);
        linesmartorellvilacastellbisbal.add(s8);
        Station martorellvilacastellbisbal = stationRepository.save(new Station(null, "Martorell - Vila | Castellbisbal", new Location(41.475881, 1.939033), linesmartorellvilacastellbisbal));

        ArrayList<Line> linesmasquefa = new ArrayList<>();
        linesmasquefa.add(r6);
        linesmasquefa.add(r60);
        Station masquefa = stationRepository.save(new Station(null, "Masquefa", new Location(41.502833, 1.812558), linesmasquefa));

        ArrayList<Line> linesmirasol = new ArrayList<>();
        linesmirasol.add(s1);
        linesmirasol.add(s5);
        Station mirasol = stationRepository.save(new Station(null, "Mira-sol", new Location(41.469197, 2.061967), linesmirasol));

        ArrayList<Line> linesmolinouciutatcooperativa = new ArrayList<>();
        linesmolinouciutatcooperativa.add(l8);
        linesmolinouciutatcooperativa.add(s33);
        linesmolinouciutatcooperativa.add(s4);
        linesmolinouciutatcooperativa.add(s8);
        linesmolinouciutatcooperativa.add(r5);
        linesmolinouciutatcooperativa.add(r6);
        Station molinouciutatcooperativa = stationRepository.save(new Station(null, "Molí Nou | Ciutat Cooperativa", new Location(41.358067, 2.034914), linesmolinouciutatcooperativa));

        ArrayList<Line> linesmonistrolmontserrat = new ArrayList<>();
        linesmonistrolmontserrat.add(r5);
        linesmonistrolmontserrat.add(r50);
        Station monistroldemontserrat = stationRepository.save(new Station(null, "Monistrol de Montserrat", new Location(41.610339, 1.849122), linesmonistrolmontserrat));

        ArrayList<Line> linesmuntaner = new ArrayList<>();
        linesmuntaner.add(l6);
        linesmuntaner.add(s1);
        linesmuntaner.add(s2);
        linesmuntaner.add(s5);
        linesmuntaner.add(s55);
        Station muntaner = stationRepository.save(new Station(null, "Muntaner", new Location(41.398872, 2.142994), linesmuntaner));

        ArrayList<Line> linesolesamontserrat = new ArrayList<>();
        linesolesamontserrat.add(s4);
        linesolesamontserrat.add(r5);
        linesolesamontserrat.add(r50);
        Station olesamontserrat = stationRepository.save(new Station(null, "Olessa de Montserrat", new Location(41.541142, 1.888661), linesolesamontserrat));

        ArrayList<Line> linespadua = new ArrayList<>();
        linespadua.add(l7);
        Station padua = stationRepository.save(new Station(null, "Pàdua", new Location(41.403361, 2.142756), linespadua));

        ArrayList<Line> lineselpalau = new ArrayList<>();
        lineselpalau.add(s4);
        lineselpalau.add(s8);
        lineselpalau.add(r5);
        lineselpalau.add(r6);
        Station elpalau = stationRepository.save(new Station(null, "El Palau", new Location(41.455817, 1.962231), lineselpalau));

        ArrayList<Line> linespalaunoguera = new ArrayList<>();
        linespalaunoguera.add(ca7);
        Station palaunoguera = stationRepository.save(new Station(null, "Palau de Noguera", new Location(42.139458, 0.893411), linespalaunoguera));

        ArrayList<Line> linespalleja = new ArrayList<>();
        linespalleja.add(s4);
        linespalleja.add(s8);
        linespalleja.add(r5);
        linespalleja.add(r6);
        linespalleja.add(r50);
        Station palleja = stationRepository.save(new Station(null, "Pallejà", new Location(41.420917, 1.995528), linespalleja));

        ArrayList<Line> linespeufunicular = new ArrayList<>();
        linespeufunicular.add(s1);
        linespeufunicular.add(s2);
        Station peufunicular = stationRepository.save(new Station(null, "Peu del Funicular", new Location(41.409058, 2.111425), linespeufunicular));

        ArrayList<Line> linespiera = new ArrayList<>();
        linespiera.add(r6);
        linespiera.add(r60);
        Station piera = stationRepository.save(new Station(null, "Piera", new Location(41.525908, 1.754383), linespiera));

        ArrayList<Line> linesplcatalunya = new ArrayList<>();
        linesplcatalunya.add(l6);
        linesplcatalunya.add(l7);
        linesplcatalunya.add(s1);
        linesplcatalunya.add(s2);
        linesplcatalunya.add(s5);
        linesplcatalunya.add(s55);
        Station plcatalunya = stationRepository.save(new Station(null, "Plaça de Catalunya", new Location(41.387028, 2.170069), linesplcatalunya));

        ArrayList<Line> linesplespanya = new ArrayList<>();
        linesplespanya.add(l8);
        linesplespanya.add(s33);
        linesplespanya.add(s4);
        linesplespanya.add(s8);
        linesplespanya.add(r5);
        linesplespanya.add(r6);
        linesplespanya.add(r50);
        linesplespanya.add(r60);
        Station plespanya = stationRepository.save(new Station(null, "Barcelona - Pl. Espanya", new Location(41.375036, 2.149164), linesplespanya));

        ArrayList<Line> linesplacamolina = new ArrayList<>();
        linesplacamolina.add(l7);
        Station placamolina = stationRepository.save(new Station(null, "Plaça Molina", new Location(41.401667, 2.146667), linesplacamolina));

        ArrayList<Line> lineslesplanes = new ArrayList<>();
        lineslesplanes.add(s1);
        lineslesplanes.add(s2);
        Station lesplanes = stationRepository.save(new Station(null, "Les Planes", new Location(41.427397, 2.0915), lineslesplanes));

        ArrayList<Line> lineslapoblaclaramunt = new ArrayList<>();
        lineslapoblaclaramunt.add(r6);
        lineslapoblaclaramunt.add(r60);
        Station lapoblaclaramunt = stationRepository.save(new Station(null, "La Pobla de Claramunt", new Location(41.554567, 1.677847), lineslapoblaclaramunt));

        ArrayList<Line> lineslapoblasegur = new ArrayList<>();
        lineslapoblasegur.add(ca7);
        Station lapoblasegur = stationRepository.save(new Station(null, "La Pobla de Segur", new Location(42.23981, 0.965976), lineslapoblasegur));

        ArrayList<Line> linesprovenca = new ArrayList<>();
        linesprovenca.add(l6);
        linesprovenca.add(l7);
        linesprovenca.add(s1);
        linesprovenca.add(s2);
        linesprovenca.add(s5);
        linesprovenca.add(s55);
        Station provenca = stationRepository.save(new Station(null, "Provença", new Location(41.395653, 2.160456), linesprovenca));

        ArrayList<Line> linesputxet = new ArrayList<>();
        linesputxet.add(l7);
        Station putxet = stationRepository.save(new Station(null, "El Putxet", new Location(41.405833, 2.139167), linesputxet));

        ArrayList<Line> linesquatrecamins = new ArrayList<>();
        linesquatrecamins.add(s4);
        linesquatrecamins.add(s8);
        linesquatrecamins.add(r5);
        linesquatrecamins.add(r50);
        Station quatrecamins = stationRepository.save(new Station(null, "Quatre Camins", new Location(41.406956, 2.001636), linesquatrecamins));

        ArrayList<Line> linesreinaelisenda = new ArrayList<>();
        linesreinaelisenda.add(l12);
        Station reinaelisenda = stationRepository.save(new Station(null, "Reina Elisenda", new Location(41.399092, 2.119278), linesreinaelisenda));

        ArrayList<Line> linesrubi = new ArrayList<>();
        linesrubi.add(s1);
        linesrubi.add(s5);
        Station rubi = stationRepository.save(new Station(null, "Rubí", new Location(41.486294, 2.031244), linesrubi));

        ArrayList<Line> linescanfeuigracia = new ArrayList<>();
        linescanfeuigracia.add(s2);
        Station canfeuigracia = stationRepository.save(new Station(null, "Can Feu | Gràcia", new Location(41.542667, 2.101039), linescanfeuigracia));

        ArrayList<Line> linessabadellrambla = new ArrayList<>();
        linessabadellrambla.add(s2);
        Station sabadellrambla = stationRepository.save(new Station(null, "Sabadell - Rambla", new Location(41.54556, 2.109675), linessabadellrambla));

        ArrayList<Line> linessalaspallars = new ArrayList<>();
        linessalaspallars.add(ca7);
        Station salaspallars = stationRepository.save(new Station(null, "Salàs del Pallars", new Location(42.209975, 0.948769), linessalaspallars));

        ArrayList<Line> linessantandreubarca = new ArrayList<>();
        linessantandreubarca.add(s4);
        linessantandreubarca.add(s8);
        linessantandreubarca.add(r5);
        linessantandreubarca.add(r6);
        linessantandreubarca.add(r50);
        linessantandreubarca.add(r60);
        Station santandreubarca = stationRepository.save(new Station(null, "Sant Andreu de la Barca", new Location(41.446742, 1.973289), linessantandreubarca));

        ArrayList<Line> linessantboi = new ArrayList<>();
        linessantboi.add(l8);
        linessantboi.add(s33);
        linessantboi.add(s4);
        linessantboi.add(s8);
        linessantboi.add(r5);
        linessantboi.add(r6);
        linessantboi.add(r50);
        linessantboi.add(r60);
        Station santboi = stationRepository.save(new Station(null, "Sant Boi", new Location(41.348133, 2.043219), linessantboi));

        ArrayList<Line> linessantcugat = new ArrayList<>();
        linessantcugat.add(s1);
        linessantcugat.add(s2);
        linessantcugat.add(s5);
        linessantcugat.add(s55);
        Station santcugat = stationRepository.save(new Station(null, "Sant Cugat", new Location(41.467869, 2.078361), linessantcugat));

        ArrayList<Line> linessantestevesesrovires = new ArrayList<>();
        linessantestevesesrovires.add(r6);
        linessantestevesesrovires.add(r60);
        Station santestevesesrovires = stationRepository.save(new Station(null, "Sant Esteve Sesrovires", new Location(41.497597, 1.872492), linessantestevesesrovires));

        ArrayList<Line> linessantgervasi = new ArrayList<>();
        linessantgervasi.add(l6);
        linessantgervasi.add(s5);
        linessantgervasi.add(s55);
        Station santgervasi = stationRepository.save(new Station(null, "Sant Gervasi", new Location(41.401189, 2.147078), linessantgervasi));

        ArrayList<Line> linessantjoan = new ArrayList<>();
        linessantjoan.add(s2);
        linessantjoan.add(s55);
        Station santjoan = stationRepository.save(new Station(null, "Sant Joan", new Location(41.4904, 2.076964), linessantjoan));

        ArrayList<Line> linessantjosep = new ArrayList<>();
        linessantjosep.add(l8);
        linessantjosep.add(s33);
        linessantjosep.add(s4);
        linessantjosep.add(s8);
        linessantjosep.add(r5);
        linessantjosep.add(r6);
        linessantjosep.add(r50);
        linessantjosep.add(r60);
        Station santjosep = stationRepository.save(new Station(null, "Sant Josep", new Location(41.360833, 2.110639), linessantjosep));

        ArrayList<Line> linessantllorencmontgai = new ArrayList<>();
        linessantllorencmontgai.add(ca7);
        Station santllorencmontgai = stationRepository.save(new Station(null, "Sant Llorenç de Montgai", new Location(41.866353, 0.832583), linessantllorencmontgai));

        ArrayList<Line> linessantquirze = new ArrayList<>();
        linessantquirze.add(s2);
        Station santquirze = stationRepository.save(new Station(null, "Sant Quirze", new Location(41.53005, 2.088633), linessantquirze));

        ArrayList<Line> linessantvicenchorts = new ArrayList<>();
        linessantvicenchorts.add(s33);
        linessantvicenchorts.add(s4);
        linessantvicenchorts.add(s8);
        linessantvicenchorts.add(r5);
        linessantvicenchorts.add(r6);
        linessantvicenchorts.add(r50);
        linessantvicenchorts.add(r60);
        Station santvicenchorts = stationRepository.save(new Station(null, "Sant Vicenç dels Horts", new Location(41.388139, 2.012464), linessantvicenchorts));

        ArrayList<Line> linessantvicenccastellgali = new ArrayList<>();
        linessantvicenccastellgali.add(r5);
        linessantvicenccastellgali.add(r50);
        Station santvicenccastellgali = stationRepository.save(new Station(null, "Sant Vicenç - Castellgalí", new Location(41.667917, 1.859753), linessantvicenccastellgali));

        ArrayList<Line> linessantacolomacervello = new ArrayList<>();
        linessantacolomacervello.add(s33);
        linessantacolomacervello.add(s4);
        linessantacolomacervello.add(s8);
        linessantacolomacervello.add(r6);
        linessantacolomacervello.add(r60);
        Station santacolomacervello = stationRepository.save(new Station(null, "Santa Coloma de Cervelló", new Location(41.370114, 2.023803), linessantacolomacervello));

        ArrayList<Line> linessantalinya = new ArrayList<>();
        linessantalinya.add(ca7);
        Station santalinya = stationRepository.save(new Station(null, "Santa Linya", new Location(41.931281, 0.852061), linessantalinya));

        ArrayList<Line> linessarria = new ArrayList<>();
        linessarria.add(l6);
        linessarria.add(l12);
        linessarria.add(l7);
        linessarria.add(s1);
        linessarria.add(s2);
        linessarria.add(s5);
        linessarria.add(s55);
        Station sarria = stationRepository.save(new Station(null, "Sarrià", new Location(41.398744, 2.125542), linessarria));

        ArrayList<Line> linestermens = new ArrayList<>();
        linestermens.add(ca7);
        Station termens = stationRepository.save(new Station(null, "Térmens", new Location(41.716511, 0.763086), linestermens));

        ArrayList<Line> linesterrassarambla = new ArrayList<>();
        linesterrassarambla.add(s1);
        Station terrassarambla = stationRepository.save(new Station(null, "Terrassa Rambla", new Location(41.56048, 2.007628), linesterrassarambla));

        ArrayList<Line> linesvallparadisuniversitat = new ArrayList<>();
        linesvallparadisuniversitat.add(s1);
        Station vallparadisuniversitat = stationRepository.save(new Station(null, "Vallparadís Universitat", new Location(41.563441, 2.019068), linesvallparadisuniversitat));

        ArrayList<Line> linesterrassanord = new ArrayList<>();
        linesterrassanord.add(s1);
        Station terrassanord = stationRepository.save(new Station(null, "Terrassa Estació del Nord", new Location(41.569944, 2.014272), linesterrassanord));

        ArrayList<Line> linesterrassanacionsunides = new ArrayList<>();
        linesterrassanacionsunides.add(s1);
        Station terrassanacionsunides = stationRepository.save(new Station(null, "Terrassa Nacions Unides", new Location(41.580245, 2.013741), linesterrassanacionsunides));

        ArrayList<Line> linestremp = new ArrayList<>();
        linestremp.add(ca7);
        Station tremp = stationRepository.save(new Station(null, "Tremp", new Location(42.167422, 0.891058), linestremp));

        ArrayList<Line> linestrestorres = new ArrayList<>();
        linestrestorres.add(l6);
        linestrestorres.add(s5);
        linestrestorres.add(s55);
        Station trestorres = stationRepository.save(new Station(null, "Les Tres Torres", new Location(41.397842, 2.1309), linestrestorres));

        ArrayList<Line> linesuab = new ArrayList<>();
        linesuab.add(s2);
        linesuab.add(s55);
        Station uab = stationRepository.save(new Station(null, "Universitat Autònoma", new Location(41.502972, 2.10245), linesuab));

        ArrayList<Line> linesvallbonaanoia = new ArrayList<>();
        linesvallbonaanoia.add(r6);
        linesvallbonaanoia.add(r60);
        Station vallbonaanoia = stationRepository.save(new Station(null, "Vallbona d'Anoia", new Location(41.520178, 1.709006), linesvallbonaanoia));

        ArrayList<Line> linesvalldoreix = new ArrayList<>();
        linesvalldoreix.add(s1);
        linesvalldoreix.add(s2);
        linesvalldoreix.add(s5);
        linesvalldoreix.add(s55);
        Station valldoreix = stationRepository.save(new Station(null, "Valldoreix", new Location(41.457836, 2.068261), linesvalldoreix));

        ArrayList<Line> linesvallfogonabalaguer = new ArrayList<>();
        linesvallfogonabalaguer.add(ca7);
        Station vallfogonabalaguer = stationRepository.save(new Station(null, "Vallfogona de Balaguer", new Location(41.757314, 0.806347), linesvallfogonabalaguer));

        ArrayList<Line> linesvilanovabarca = new ArrayList<>();
        linesvilanovabarca.add(ca7);
        Station vilanovabarca = stationRepository.save(new Station(null, "Vilanova de la Barca", new Location(41.687353, 0.7279), linesvilanovabarca));

        ArrayList<Line> linesvilanovasal = new ArrayList<>();
        linesvilanovasal.add(ca7);
        Station vilanovasal = stationRepository.save(new Station(null, "Vilanova de la Sal", new Location(41.91205, 0.830417), linesvilanovasal));

        ArrayList<Line> linesvilanovacami = new ArrayList<>();
        linesvilanovacami.add(r6);
        linesvilanovacami.add(r60);
        Station vilanovacami = stationRepository.save(new Station(null, "Vilanova del Camí", new Location(41.573194, 1.642106), linesvilanovacami));

        ArrayList<Line> linesvolpelleres = new ArrayList<>();
        linesvolpelleres.add(s2);
        linesvolpelleres.add(s55);
        Station volpelleres = stationRepository.save(new Station(null, "Volpelleres", new Location(41.481247, 2.072928), linesvolpelleres));

    }
}
