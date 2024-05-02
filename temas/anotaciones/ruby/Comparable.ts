
interface Comparable {
    compareTo(other: any): number;
    equals(other: any): boolean;
    toString(): string;
}


// Decorador -> @Comparable
export function ComparableDecorator(constructor:Function){
    return function(target){
        target.prototype.compareTo = function(other){
            if (this.id < other.id) {
                return -1;
            } else if (this.id > other.id) {
                return 1;
            } else {
                return 0;
            }
        }
        target.prototype.equals = function(other){
            return this.id === other.id;
        }
        target.prototype.toString = function(){
            return this.id;
        }
    }
}
