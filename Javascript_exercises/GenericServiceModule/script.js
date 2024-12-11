let counter = 0;
class Person {
    constructor(id, name, age, favoriteFood) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }
}

class PersonService {
    constructor(arrayWithPeople) {
        this.arrayWithPeople = arrayWithPeople;
    }


    


    getName(id) {
        const person = this.get(id);
        if (person) {
            return `My name is ${person.name}`;
        }
        return 'Person not found';
    }


    add(name, age, favoriteFood) {
        counter += 1;
        const id = counter;
        const newPerson = new Person(id, name, age, favoriteFood);
        this.arrayWithPeople.push(newPerson);
        return newPerson;
    }

    remove(id) {
        const index = this.arrayWithPeople.findIndex(person => person.id === id);
        if (index !== -1) {
            return this.arrayWithPeople.splice(index, 1) + "removed"; 
        }
        return null;
    }

    destroy(){
        this.arrayWithPeople = [];
        return 'Array destroyed';

    }

    updateAll(id,name, age, favoriteFood) {
        const personUpdated = this.get(id);

        if (personUpdated) {
            personUpdated.name = name;
            personUpdated.age = age;
            personUpdated.favoriteFood = favoriteFood;
            return personUpdated;
        }
        return "error: Person not found, cant update";
    }
    updateName(id, name) {
        const personUpdated = this.get(id);

        if (personUpdated) {
            personUpdated.name = name;
            return personUpdated;
        }
        return "error: Person not found, cant update";
    }

    updateAge(id, age) {
        const personUpdated = this.get(id);

        if (personUpdated) {
            personUpdated.age = age;
            return personUpdated;
        }
        return "error: Person not found, cant update";
    }
    updateFavoriteFood(id, favoriteFood) {
        const personUpdated = this.get(id);

        if (personUpdated) {
            personUpdated.favoriteFood = favoriteFood;
            return personUpdated;
        }
        return "error: Person not found, cant update";
    }

    get(id) {
        return this.arrayWithPeople.find(person => person.id === id) || null;
    }

    list() {
        return this.arrayWithPeople;
    }
    
}

const personService = new PersonService([]);





personService.add('Alice', 25, 'Pizza');
console.log(personService.get(1)); 

// console.log(personService.get(2)); 

// console.log(personService.getAll()); 

console.log(personService.remove(1));
console.log(personService.get(1)); 


//console.log(personService.get(1)); 

personService.add('Bob', 30, 'Burgers');
console.log(personService.get(2)); 

personService.updateAll(2, 'joao', 30, 'Burgers');



personService.add('Charlie', 28, 'Salads');
console.log(personService.get(3));

console.log(personService.list()); 

//console.log(personService.getName(2));

