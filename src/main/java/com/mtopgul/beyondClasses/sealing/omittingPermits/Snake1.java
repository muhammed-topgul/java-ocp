package com.mtopgul.beyondClasses.sealing.omittingPermits;

/**
 * @author muhammed-topgul
 * @since 15/02/2024 22:36
 */
//public sealed class Snake1 {
//public sealed class Snake1 permits Cobra1 { // DOES NOT COMPILE
public sealed class Snake1 permits Snake1.Cobra1 {
    final class Cobra1 extends Snake1 {
    }
}
