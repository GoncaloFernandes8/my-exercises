class Person {
    constructor(name, age, favoriteFood) {
        this.id = null; // Será atribuído pelo serviço
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }
}

const personService = (function () {
    let arrayWithPeople = [];
    let counter = 0;

    return {
        get: function (id) {
            return arrayWithPeople.find(person => person.id === id) || null;
        },

        getName: function (id) {
            const person = this.get(id);
            return person ? `My name is ${person.name}` : 'Person not found';
        },

        list: function () {
            return arrayWithPeople;
        },

        add: function (person) {
            counter += 1;
            person.id = counter;
            arrayWithPeople.push(person);
            return person;
        },

        update: function (id, updatedPerson) {
            const person = this.get(id);
            if (person) {
                person.name = updatedPerson.name || person.name;
                person.age = updatedPerson.age || person.age;
                person.favoriteFood = updatedPerson.favoriteFood || person.favoriteFood;
                return person;
            }
            return 'Person not found';
        },

        remove: function (id) {
            const index = arrayWithPeople.findIndex(person => person.id === id);
            if (index !== -1) {
                const removedPerson = arrayWithPeople.splice(index, 1)[0];
                return `${removedPerson.name} has been removed`;
            }
            return 'Person not found';
        },

        destroy: function () {
            arrayWithPeople = [];
            return 'All people have been removed';
        },
    };
})();

// Testes
const service = personService;

// Adicionando pessoas
let person1 = new Person('Alice', 25, 'Pizza');
service.add(person1);

let person2 = new Person('Bob', 30, 'Burgers');
service.add(person2);

console.log(service.list()); // Lista com Alice e Bob

// Obtendo pessoa pelo ID
console.log(service.get(10)); // Alice

// Atualizando pessoa
console.log(service.update(1, { name: 'Alicia', age: 26 })); // Atualizando Alice
console.log(service.get(1)); // Alicia

// Removendo pessoa
console.log(service.remove(1)); // "Alicia has been removed"
console.log(service.get(1)); // "Person not found"

// Destruindo todos os registros
console.log(service.destroy()); // "All people have been removed"
console.log(service.list()); // []
