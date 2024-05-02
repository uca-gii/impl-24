

import {expect} from 'chai';

import { BankAccount } from './BankAccount';

describe('BankAccount', () => {

    it('should be able to compare two bank accounts', () => {
        const account1 = new BankAccount('123');
        const account2 = new BankAccount('456');
        const account3 = new BankAccount('123');

        expect(account1.compareTo(account2)).to.be.lessThan(0);
        expect(account2.compareTo(account1)).to.be.greaterThan(0);
        expect(account1.compareTo(account3)).to.be.equal(0);
    });

    it('should be able to compare two bank accounts using equals', () => {
        const account1 = new BankAccount('123');
        const account2 = new BankAccount('456');
        const account3 = new BankAccount('123');

        expect(account1.equals(account2)).to.be.false;
        expect(account2.equals(account1)).to.be.false;
        expect(account1.equals(account3)).to.be.true;
    });

    it('should be able to compare two bank accounts using toString', () => {
        const account = new BankAccount('123');

        expect(account.toString()).to.be.equal('123');
    });
});

//  npm install -g typescript@latest
// npm install --save-dev @types/chai
// npm install --save-dev @types/mocha
