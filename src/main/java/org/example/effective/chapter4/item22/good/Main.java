package org.example.effective.chapter4.item22.good;

import lombok.extern.slf4j.Slf4j;

import static org.example.effective.chapter4.item22.good.GoodPhysicalConstants.*;

@Slf4j
public class Main {

    private static double mols = 2.0; // 2몰

    // 2몰당 입자의 수 개산 (atoms)
    private static double atoms = mols * AVOGADROS_NUMBER;

    public static void main(String[] args) {
        log.debug("Atoms : " + atoms);
    }
}
