
// BankAccount.ts

import { ComparableDecorator } from './Comparable';

@ComparableDecorator
export class BankAccount {
    private readonly id: string;
    private creationDate: Date;

    constructor(id: string) {
        this.id = id;
    }

    getCreationDate(): Date {
        return this.creationDate;
    }

    setCreationDate(creationDate: Date): void {
        this.creationDate = creationDate;
    }

    getId(): string {
        return this.id;
    }
}