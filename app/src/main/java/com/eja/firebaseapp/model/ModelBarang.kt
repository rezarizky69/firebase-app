package com.eja.firebaseapp.model

class ModelBarang {

    var key: String? = null
    var nama: String? = null
    var merk: String? = null
    var tipe: String? = null
    var harga: String? = null

    constructor() {}

    constructor(namaBarang: String?, merkBarang: String?, tipeBarang: String?, hargaBarang: String?) {
        nama = namaBarang
        merk = merkBarang
        tipe = tipeBarang
        harga = hargaBarang
    }
}