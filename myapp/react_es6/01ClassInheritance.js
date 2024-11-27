class Car {
    constructor(name){
        this.brand = name;
    }

    present(){
        return `i have a ${this.brand}`;
    }
}

class Model extends Car{
    constructor(name, mymodel){
        super(name);
        this.mymodel = mymodel;

    }

    show(){
        return `${this.present()}, it is a ${this.mymodel}`;
    }
}

const mycar = new Model("Ford", "mustang")
console.log(mycar.show()) // i have a Ford, it is a mustang