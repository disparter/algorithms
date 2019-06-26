package br.com.github.disparter.study.queue;

import java.util.Date;
import java.util.LinkedList;

public class AnimalShelter {

	LinkedList<Animal> animals = new LinkedList<>();
	LinkedList<Cat> delayedCats = new LinkedList<>();
	LinkedList<Dog> delayedDogs = new LinkedList<>();
	
	
	public class Animal {
		String name;
		Date arrival;		
	}

	public class Dog extends Animal{public Dog(String name){this.name = name;}}
	public class Cat extends Animal{public Cat(String name){this.name = name;}}
	
	public void enqueue(Animal animal) {
		animal.arrival = new Date();
		animals.add(animal);
	}
	
	public Animal dequeue() {
		return animals.poll();
	}
	
	public Dog dequeueDog() {
		if(delayedDogs.peek() == null) {
			Animal peek = animals.peek();
			if(peek == null) {
				return null;
			}else if(peek instanceof Dog) {
				return (Dog) animals.poll();
			}else {
				delayedCats.add((Cat) animals.poll());
				return dequeueDog();
			}
		}
		return delayedDogs.poll();
	}

	public Cat dequeueCat() {
		if(delayedCats.peek() == null) {
			Animal peek = animals.peek();
			if(peek == null) {
				return null;
			}else if(peek instanceof Cat) {
				return (Cat) animals.poll();
			}else {
				delayedDogs.add((Dog) animals.poll());
				return dequeueCat();
			}
		}
		return delayedCats.poll();
	}
	
	public Cat createCat(Integer i) {
		return new Cat(i.toString());
	}
	
	public Dog createDog(Integer i) {
		return new Dog(i.toString());
	}
	
	public void print(Animal a) {
		if(a != null) {
			System.out.println(a.name + " -- " + a.arrival);
		}
	}
	
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		for(int i = 0; i < 1000; i++) {
			Animal animal = null;
			if(i%2==0) {
				animal = shelter.createDog(i);
			}else {
				animal = shelter.createCat(i);
			}
			shelter.enqueue(animal);
		}
		
		while(!shelter.animals.isEmpty()) {
			shelter.print(shelter.dequeue());
			shelter.print(shelter.dequeueCat());
			shelter.print(shelter.dequeueDog());
		}
	}
}
