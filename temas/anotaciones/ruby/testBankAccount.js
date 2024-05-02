"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var chai_1 = require("chai");
var BankAccount_1 = require("./BankAccount");
describe('BankAccount', function () {
    it('should be able to compare two bank accounts', function () {
        var account1 = new BankAccount_1.BankAccount('123');
        var account2 = new BankAccount_1.BankAccount('456');
        var account3 = new BankAccount_1.BankAccount('123');
        (0, chai_1.expect)(account1.compareTo(account2)).to.be.lessThan(0);
        (0, chai_1.expect)(account2.compareTo(account1)).to.be.greaterThan(0);
        (0, chai_1.expect)(account1.compareTo(account3)).to.be.equal(0);
    });
    it('should be able to compare two bank accounts using equals', function () {
        var account1 = new BankAccount_1.BankAccount('123');
        var account2 = new BankAccount_1.BankAccount('456');
        var account3 = new BankAccount_1.BankAccount('123');
        (0, chai_1.expect)(account1.equals(account2)).to.be.false;
        (0, chai_1.expect)(account2.equals(account1)).to.be.false;
        (0, chai_1.expect)(account1.equals(account3)).to.be.true;
    });
    it('should be able to compare two bank accounts using toString', function () {
        var account = new BankAccount_1.BankAccount('123');
        (0, chai_1.expect)(account.toString()).to.be.equal('123');
    });
});
//  npm install -g typescript@latest
// npm install --save-dev @types/chai
// npm install --save-dev @types/mocha
//npm i --save-dev @types/jest
